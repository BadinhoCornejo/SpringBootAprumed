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

	@PutMapping(value = "eliminarItem/{id}")
	public Ejemplar eliminarItem(@PathVariable(value = "id") int id) {

		Ejemplar ejemplar = ejemplarService.getEjemplarById(id);

		LineaVenta lineaVenta = lineaVentaService.findLineaVentaByEjemplarID(id);

		lineaVentaService.deleteLineaVentaById(lineaVenta.getLineaVentaID());
		;

		Libro libro = ejemplar.getLibro();

		libro = ejemplar.getLibro();
		libro.addStock();
		libro.verificarStock();

		libroService.addLibro(libro);

		ejemplar.setActivo();
		return ejemplarService.addEjemplar(ejemplar);

	}

	@GetMapping("{userID}/carrito")
	public List<Ejemplar> verCarrito(@PathVariable(value = "userID") int userID) {

		
		Usuario usuario = usuarioService.getUsuario(userID);

		Venta venta = ventaService.getVentaUsuario(usuario.getUsuarioID());

		List<LineaVenta> lineasVenta = lineaVentaService.findLineaVentaByVentaID(venta.getVentaID());

		List<Ejemplar> carrito = new ArrayList<Ejemplar>();

		Double subtotal = 0d;

		for (LineaVenta lineaVenta : lineasVenta) {
			Ejemplar ejemplar = new Ejemplar();

			ejemplar = lineaVenta.getEjemplar();

			subtotal += ejemplar.getLibro().getPrecio();

			carrito.add(ejemplar);
		}

		return carrito;
	}

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



	@PostMapping(value = "{userID}/addReceptor", consumes = "application/json", produces = "application/json")
	public Receptor addReceptorPost(@PathVariable(value = "userID") int userID,@RequestBody Receptor receptor) {


		Usuario usuario = usuarioService.getUsuario(userID);

		Venta venta = ventaService.getVentaUsuario(usuario.getUsuarioID());

		List<LineaVenta> lineasVenta = lineaVentaService.findLineaVentaByVentaID(venta.getVentaID());

		Double subtotal = 0d;

		for (LineaVenta lineaVenta : lineasVenta) {

			Ejemplar ejemplar = new Ejemplar();

			ejemplar = lineaVenta.getEjemplar();
			ejemplar.setVendido();

			ejemplarService.addEjemplar(ejemplar);

			subtotal += ejemplar.getLibro().getPrecio();

		}

		ComprobantePago cp = new ComprobantePago();

		Instant instant = Instant.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
				.withZone(ZoneId.systemDefault());
		String fecha = formatter.format(instant);
		String hora = formatter.format(instant);

		venta.setFechaVenta(fecha);
		venta.setHoraVenta(hora);
		venta.setRealizada();
		venta.setUsuario(usuario);
		ventaService.addVenta(venta);

		Venta newVenta = new Venta();
		newVenta.setActivo();
		newVenta.setUsuario(usuario);
		ventaService.addVenta(newVenta);

		cp.setFechaCp(fecha);
		cp.setHoraCp(hora);
		cp.setRuc("20554394273");
		cp.setVenta(venta);
		cp.setSubtotal(subtotal);

		comprobantePagoService.addCp(cp);
		receptor.setVenta(venta);

		return receptorService.addReceptor(receptor);

	}


	@GetMapping(value = "listaVentas")
	public List<Venta> listVenta(Model model ) {
		List<Venta> lista = ventaService.listaVentas();

		return lista;
	}
	
	@PutMapping(value = "delete/{id}")
	public Venta eliminarVentaGet(@PathVariable("id") int id) {
		Venta venta = null;
		UsuarioViewModel usr;

			venta = ventaService.getVentaById(id);
			venta.setInactiva();

			return ventaService.addVenta(venta);

	}
	

}
