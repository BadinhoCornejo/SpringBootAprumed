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

	@GetMapping(value = "agregarCarrito/{userID}/{id}")
	public Ejemplar agregarAlCarrito(@PathVariable(value = "userID") int userID, @PathVariable(value = "id") int id ) {
		Usuario usuario = usuarioService.getUsuario(userID);
		Venta venta = ventaService.getVentaUsuario(usuario.getUsuarioID());

		Ejemplar ejemplar = ejemplarService.getEjemplarById(id);

		LineaVenta lineaVenta = new LineaVenta();

		lineaVenta.setEjemplar(ejemplar);
		lineaVenta.setVenta(venta);

		lineaVentaService.addLineaVenta(lineaVenta);

		ejemplar.setEnCarrito();
		Libro libro = ejemplar.getLibro();

		libro = ejemplar.getLibro();
		libro.quitStock();
		libro.verificarStock();

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
