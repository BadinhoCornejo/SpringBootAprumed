package com.aprumed.SpringBootAprumed.restControllers;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.*;
import com.aprumed.SpringBootAprumed.services.*;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sales")
public class VentaRestController {
	@Autowired
	VentaService ventaService;

	@Autowired
	LineaVentaService lineaVentaService;

	@Autowired
	EjemplarService ejemplarService;

	@Autowired
	ReceptorService receptorService;

	@Autowired
	LibroService libroService;

	@Autowired
	ComprobantePagoService comprobantePagoService;

	@Autowired
	UsuarioService usuarioService;

	//Realizar la venta (core)
	@PutMapping(value = "doSale/{subtotal}", consumes = "application/json", produces = "application/json")
	public Venta doSale(@PathVariable("subtotal") double subtotal,@RequestBody Venta sale){
		Instant instant = Instant.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
				.withZone(ZoneId.systemDefault());
		String fecha = formatter.format(instant);
		String hora = formatter.format(instant);

		sale.setFechaVenta(fecha);
		sale.setHoraVenta(hora);
		sale.setRealizada();
		ventaService.addVenta(sale);

		ComprobantePago cp = new ComprobantePago();

		cp.setFechaCp(fecha);
		cp.setHoraCp(hora);
		cp.setRuc("20554394273");
		cp.setVenta(sale);
		cp.setSubtotal(subtotal);

		comprobantePagoService.addCp(cp);

		Venta newVenta = new Venta();
		newVenta.setActivo();
		newVenta.setUsuario(sale.getUsuario());
		return ventaService.addVenta(newVenta);
	}

	@PostMapping(value = "addReceptor/{ventaID}", consumes = "application/json", produces = "application/json")
	public Receptor addReceptor(@PathVariable("ventaID") int ventaID,@RequestBody Receptor receptor){
		Venta venta = new Venta();
		venta.setVentaID(ventaID);
		receptor.setVenta(venta);
		return receptorService.addReceptor(receptor);
	}

	//Obtener la venta activa del usuario
	@GetMapping("mySale/{userID}")
	public Venta getVentaUsuario(@PathVariable("userID") int userID){
		Usuario usuario = usuarioService.getUsuario(userID);
		return ventaService.getVentaUsuario(usuario.getUsuarioID());
	}

	//Agregar un producto al carrito
	@GetMapping("agregarCarrito/{userID}/{ejemplarID}")
	public Ejemplar agregarAlCarrito(@PathVariable("userID") int userID, @PathVariable("ejemplarID") int ejemplarID ) {

		Usuario usuario = usuarioService.getUsuario(userID);
		Venta venta = ventaService.getVentaUsuario(usuario.getUsuarioID());

		Ejemplar ejemplar = ejemplarService.getEjemplarById(ejemplarID);

		LineaVenta lineaVenta = lineaVentaService.findLineaVentaByEjemplarID(ejemplar.getEjemplarID());

		if(lineaVenta != null){
			return ejemplar;
		}else
		{
			lineaVenta = new LineaVenta();

			lineaVenta.setEjemplar(ejemplar);
			lineaVenta.setVenta(venta);
		}

		lineaVentaService.addLineaVenta(lineaVenta);

		ejemplar.setEnCarrito();
		Libro libro = ejemplar.getLibro();

		List<Ejemplar> ejemplaresByLibro = ejemplarService.getEjemplaresByLibro(libro.getLibroID());

		libro.calcularStock(ejemplaresByLibro);

		libroService.addLibro(libro);
		return ejemplarService.addEjemplar(ejemplar);

	}

	//Ver el carrito del usuario (por la venta activa)
	@GetMapping("{userID}/myCart")
	public List<Ejemplar> getCartFromUser(@PathVariable int userID) {


		Usuario usuario = usuarioService.getUsuario(userID);

		Venta venta = ventaService.getVentaUsuario(usuario.getUsuarioID());

		List<LineaVenta> lineasVenta = lineaVentaService.findLineaVentaByVentaID(venta.getVentaID());

		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();

		for (LineaVenta lineaVenta:
			 lineasVenta) {
			Ejemplar ejemplar = new Ejemplar();

			ejemplar = lineaVenta.getEjemplar();

			ejemplares.add(ejemplar);
		}

		return ejemplares;
	}

	//Obtener los productos del carrito sin repetir
	@GetMapping("{userID}/groupCart")
	public List<Ejemplar> getGroupCartFromUser(@PathVariable int userID) {
		Usuario usuario = usuarioService.getUsuario(userID);

		List<Ejemplar> ejemplares = lineaVentaService.getEjemplaresGroup(usuario.getUsuarioID());


		return ejemplares;
	}

	//Contar la cantidad de ejemplares de un determinado libro en el carrito
	@GetMapping("{userID}/{isbn}/countCart")
	public int getCountProducts(@PathVariable int userID, @PathVariable String isbn) {
		Usuario usuario = usuarioService.getUsuario(userID);

		int cantidad = lineaVentaService.getCantidadPorEjemplar(usuario.getUsuarioID(), isbn);


		return cantidad;
	}

	//Obtener el útlimo ejemplar activo de un libro
	@GetMapping("{isbn}/oneEjemplar")
	public Ejemplar getOneEjemplar(@PathVariable String isbn) {
		return ejemplarService.getOneEjemplar(isbn);
	}

	//Eliminar un ejemplar del carrito
	@PutMapping(value = "removeItem/{ejemplarID}")
	public Ejemplar eliminarItem(@PathVariable(value = "ejemplarID") int ejemplarID) {

		Ejemplar ejemplar = ejemplarService.getEjemplarById(ejemplarID);

		LineaVenta lineaVenta = lineaVentaService.findLineaVentaByEjemplarID(ejemplarID);

		lineaVentaService.deleteLineaVentaById(lineaVenta.getLineaVentaID());
		;

		Libro libro = ejemplar.getLibro();
		List<Ejemplar> ejemplaresByLibro = ejemplarService.getEjemplaresByLibro(libro.getLibroID());

		libro.calcularStock(ejemplaresByLibro);

		libroService.addLibro(libro);

		ejemplar.setActivo();
		return ejemplarService.addEjemplar(ejemplar);

	}

	@GetMapping(value = "listaVentas")
	public List<Venta> listVenta(Model model ) {
		List<Venta> lista = ventaService.listaVentas();

		return lista;
	}

	

}
