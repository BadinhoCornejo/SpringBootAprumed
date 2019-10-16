package com.aprumed.SpringBootAprumed.controllers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.Categoria;
import com.aprumed.SpringBootAprumed.models.ComprobantePago;
import com.aprumed.SpringBootAprumed.models.Ejemplar;
import com.aprumed.SpringBootAprumed.models.Libro;
import com.aprumed.SpringBootAprumed.models.LineaVenta;
import com.aprumed.SpringBootAprumed.models.Receptor;
import com.aprumed.SpringBootAprumed.models.Usuario;
import com.aprumed.SpringBootAprumed.models.Venta;
import com.aprumed.SpringBootAprumed.services.ComprobantePagoService;
import com.aprumed.SpringBootAprumed.services.EjemplarService;
import com.aprumed.SpringBootAprumed.services.LibroService;
import com.aprumed.SpringBootAprumed.services.LineaVentaService;
import com.aprumed.SpringBootAprumed.services.ReceptorService;
import com.aprumed.SpringBootAprumed.services.VentaService;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;

@Controller
public class VentaController {
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

	@GetMapping(value = "/agregarCarrito/{id}")
	public String agregarAlCarrito(@PathVariable(value = "id") int id, HttpServletRequest request) {
		VerificarSessionHelper verificaSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificaSession.verificarSession(request);
		String returnView = verificaSession.verificarPermiso(usr, "/", "/dashboard", true, false);
		
		if(usr.getUsuario()==null) {
			return "redirect:/";
		}
		
		Usuario usuario = usr.getUsuario();

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
		ejemplarService.addEjemplar(ejemplar);

		return returnView;
	}

	@GetMapping(value = "/eliminarItem/{id}")
	public String eliminarItem(@PathVariable(value = "id") int id, HttpServletRequest request) {
		VerificarSessionHelper verificaSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificaSession.verificarSession(request);
		String returnView = verificaSession.verificarPermiso(usr, "/carrito", "/dashboard", true, false);

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
		ejemplarService.addEjemplar(ejemplar);

		return returnView;
	}

	@GetMapping("/carrito")
	public String verCarrito(Model model, HttpServletRequest request) {
		VerificarSessionHelper verificaSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificaSession.verificarSession(request);
		String returnView = verificaSession.verificarPermiso(usr, "carrito", "dashboard", false, false);

		if(usr.getUsuario()==null) {
			return "redirect:/";
		}
		
		Usuario usuario = usr.getUsuario();

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

		model.addAttribute("carrito", carrito);
		model.addAttribute("user", usr);
		model.addAttribute("subtotal", subtotal);

		return returnView;
	}

	@GetMapping(value = "/addReceptor")
	public String addReceptorGet(Map<String, Object> model, HttpServletRequest request) {
		Receptor receptor = new Receptor();
		VerificarSessionHelper verificaSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificaSession.verificarSession(request);
		String returnView = verificaSession.verificarPermiso(usr, "addReceptor", "newUsuario", false, false);

		model.put("receptor", receptor);
		model.put("user", usr);
		return returnView;
	}

	@PostMapping(value = "/addReceptor")
	public String addReceptorPost(Receptor receptor, HttpServletRequest request) {

		VerificarSessionHelper verificaSession = new VerificarSessionHelper();

		UsuarioViewModel usr = verificaSession.verificarSession(request);

		Usuario usuario = usr.getUsuario();

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

		receptorService.addReceptor(receptor);
		return "redirect:/success";
	}

	@GetMapping("/success")
	public String ventaRealizada(Model model, HttpServletRequest request) {
		VerificarSessionHelper verificaSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificaSession.verificarSession(request);
		String returnView = verificaSession.verificarPermiso(usr, "success", "dashboard", false, false);

		Usuario usuario = usr.getUsuario();
		List<ComprobantePago> cps = comprobantePagoService.getLastCP(usuario.getUsuarioID());
		ComprobantePago cp = cps.get(cps.size() - 1);

		Venta venta = cp.getVenta();
		List<LineaVenta> lineasVenta = lineaVentaService.findLineaVentaByVentaID(venta.getVentaID());
		List<Ejemplar> carrito = new ArrayList<Ejemplar>();

		for (LineaVenta lineaVenta : lineasVenta) {
			Ejemplar ejemplar = new Ejemplar();

			ejemplar = lineaVenta.getEjemplar();

			carrito.add(ejemplar);
		}

		model.addAttribute("cp", cp);
		model.addAttribute("carrito", carrito);
		model.addAttribute("user", usr);

		return returnView;
	}

	@RequestMapping(value = "/listaVentas")
	public ModelAndView listVenta(Model model, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		List<Venta> lista = ventaService.listaVentas();
		for (Venta venta : lista) {
			System.out.println(venta.getVentaID());
		}
		VerificarSessionHelper verificaSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificaSession.verificarSession(request);
		view.addObject("ventas", lista);
		view.setViewName(verificaSession.verificarPermiso(usr, "index", "ventas", false, false));
		view.addObject("user",usr);
		return view;
	}
	
	@GetMapping(value = "/eliminarVenta/{id}")
	public String eliminarVentaGet(@PathVariable("id") int id, Map<String, Object> model, HttpServletRequest request) {
		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		Venta venta = null;
		String returnView;
		UsuarioViewModel usr;
		if(id>0)
		{
			venta = ventaService.getVentaById(id);
			venta.setInactiva();
			usr = verificarSession.verificarSession(request);
			returnView = verificarSession.verificarPermiso(usr, "index", "ventas", false, false);
			ventaService.addVenta(venta);
			model.put("user", usr);
			return "redirect:/listaVentas";
		}
		else
			return "redirect:/listaVentas";
	}
	

}
