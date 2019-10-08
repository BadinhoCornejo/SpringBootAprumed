package com.aprumed.SpringBootAprumed.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.Categoria;
import com.aprumed.SpringBootAprumed.models.Libro;
import com.aprumed.SpringBootAprumed.services.CategoriaService;
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

		model.put("categorias", categorias);
		String returnView = verificarSession.verificarPermiso(usr, "index", "nuevoLibro", true, false);
		model.put("user", usr);
		model.put("libro", libro);
		return returnView;

	}
	
	@PostMapping("/nuevoLibro")
	public String nuevoLibroPost(Libro libro, HttpServletRequest request) {

		
		
		return "ga";

	}
}
