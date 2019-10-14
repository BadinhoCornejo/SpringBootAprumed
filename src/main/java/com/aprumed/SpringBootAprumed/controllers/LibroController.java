package com.aprumed.SpringBootAprumed.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.Categoria;
import com.aprumed.SpringBootAprumed.models.Ejemplar;
import com.aprumed.SpringBootAprumed.models.Libro;
import com.aprumed.SpringBootAprumed.models.Portada;
import com.aprumed.SpringBootAprumed.models.Usuario;
import com.aprumed.SpringBootAprumed.models.AjaxResponses.EjemplarAjaxResponseBody;
import com.aprumed.SpringBootAprumed.models.AjaxResponses.PortadaAjaxResponseBody;
import com.aprumed.SpringBootAprumed.models.AjaxResponses.UserAjaxResponseBody;
import com.aprumed.SpringBootAprumed.services.CategoriaService;
import com.aprumed.SpringBootAprumed.services.EjemplarService;
import com.aprumed.SpringBootAprumed.services.LibroService;
import com.aprumed.SpringBootAprumed.services.PortadaService;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;

	@Autowired
	private PortadaService portadaService;

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private EjemplarService ejemplarService;

	@GetMapping("/libros")
	public ModelAndView listaLibros(HttpServletRequest request) {

		ModelAndView view = new ModelAndView();

		List<Libro> libros = libroService.listLibros();

		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificarSession.verificarSession(request);

		view.addObject("libros", libros);
		view.setViewName(verificarSession.verificarPermiso(usr, "index", "libros", false, false));
		view.addObject("user", usr);
		return view;
	}

	@GetMapping("/nuevoLibro")
	public String nuevoLibroGet(Map<String, Object> model, HttpServletRequest request) {

		List<Categoria> categorias = categoriaService.listCategorias();
		Libro libro = new Libro();

		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificarSession.verificarSession(request);

		String returnView = verificarSession.verificarPermiso(usr, "index", "nuevoLibro", true, false);

		model.put("portadaUrl",
				"https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fno-image.jpg?alt=media&token=02ff92cc-31c3-4137-8e25-50fbeb850797");
		model.put("categorias", categorias);
		model.put("user", usr);
		model.put("libro", libro);
		return returnView;

	}

	@PostMapping("/nuevoLibro")
	public String nuevoLibroPost(Libro libro, HttpServletRequest request) {

		Portada portada = portadaService.getPortadaByUrl(libro.getPortada().getUrl());

		libro.setEstado("Inactivo");
		libro.setPortada(portada);

		libroService.addLibro(libro);

		return "redirect:/libros";

	}

	@GetMapping(value = "/editarLibro/{id}")
	public String editarLibroGet(@PathVariable(value = "id") int id, Map<String, Object> model,
			HttpServletRequest request) {
		Libro libro = null;
		if (id > 0)
			libro = libroService.getLibroById(id);
		else
			return "redirect:/libros";

		List<Categoria> categorias = categoriaService.listCategorias();

		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificarSession.verificarSession(request);
		String returnView = verificarSession.verificarPermiso(usr, "index", "editarLibro", false, false);

		model.put("portadaUrl", libro.getPortada().getUrl());
		model.put("categorias", categorias);
		model.put("user", usr);
		model.put("libro", libro);

		return returnView;
	}

	@PostMapping(value = "/editarLibro")
	public String editarLibroPost(Libro libro, @RequestParam("idLibro") int libroID) {
		Libro refLibro = libroService.getLibroById(libroID);
		Portada portada = portadaService.getPortadaByUrl(libro.getPortada().getUrl());
		libro.setLibroID(refLibro.getLibroID());
		libro.setPortada(portada);
		libro.verificarStock();
		libroService.addLibro(libro);
		return "redirect:/libros";
	}

	@GetMapping(value = "/eliminarLibro/{id}")
	public String eliminarLibro(@PathVariable(value = "id") int id, HttpServletRequest request) {
		Libro libro = null;
		if (id > 0) {
			libro = libroService.getLibroById(id);
			libro.setInactivo();
			libroService.addLibro(libro);
			return "redirect:/libros";
		} else {
			return "redirect:/libros";
		}

	}
	
	@PostMapping("/agregarEjemplar")
	public ResponseEntity<Object> agregarEjemplar(@RequestBody Ejemplar ejemplar, Errors errors) throws UnsupportedEncodingException{
		
		System.out.println(ejemplar.getSku());
		
		EjemplarAjaxResponseBody result = new EjemplarAjaxResponseBody();
		
		if (errors.hasErrors()) {

			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));

			return ResponseEntity.badRequest().body(result);

		}
		
		Ejemplar ejemplarExist = ejemplarService.getEjemplarBySku(ejemplar.getSku());
		if(ejemplarExist!=null) {
			result.setMsg("EjemplarExist");
			result.setResult(ejemplarExist);
			return ResponseEntity.ok(result);
		}
		
		Libro libro = libroService.getLibroById(ejemplar.getLibro().getLibroID());
		
		ejemplar.setActivo();
		
		ejemplarService.addEjemplar(ejemplar);
		
		libro.addStock();
		
		libro.verificarStock();
		
		libroService.addLibro(libro);
		
		result.setResult(ejemplar);
		
		return ResponseEntity.ok(result);
	}

	@PostMapping("/buscarPortada")
	public ResponseEntity<Object> buscarPortada(@RequestBody String portadaString, Errors errors)
			throws UnsupportedEncodingException {

		PortadaAjaxResponseBody result = new PortadaAjaxResponseBody();

		if (errors.hasErrors()) {

			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));

			return ResponseEntity.badRequest().body(result);

		}

		Portada portada = portadaService.getPortadaByUrl(portadaString);

		if (portada == null) {
			result.setMsg("Error!");
		} else {
			result.setMsg("Success!");
		}

		result.setResult(portada);

		return ResponseEntity.ok(result);
	}
}
