package com.aprumed.SpringBootAprumed.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.Categoria;
import com.aprumed.SpringBootAprumed.services.CategoriaService;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Value("${application.controller.titulo}")
	private String titulo;
	
	@RequestMapping(value = "/listaCategorias")
	public ModelAndView listCategoria(Model model, HttpServletRequest request){
		ModelAndView view=new ModelAndView();
		List<Categoria> lista = categoriaService.listCategorias();
		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificarSession.verificarSession(request);
		view.addObject("categorias",lista);
		view.setViewName(verificarSession.verificarPermiso(usr, "index", "categorias", false,false));
		view.addObject("user",usr);
		return view;
		
	}
	
	@GetMapping(value="/nuevaCategoria")
	public ModelAndView crearCategoria(Model model, HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		//Categoria categoria = new Categoria();
		//categoria = (Categoria) model;
		//categoriaService.addCategoria(categoria);
		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificarSession.verificarSession(request);
		view.setViewName(verificarSession.verificarPermiso(usr, "index", "newCategoria", false, false));
		view.addObject("user",usr);
		return view;
	}
	@PostMapping(value="/nuevaCategoria")
	public ModelAndView crearCategoria(Model model, @RequestBody Categoria categoria){
		ModelAndView view = new ModelAndView();
		categoriaService.addCategoria(categoria);
		view.setViewName("/listarCategorias");
		return view;
	}
	
	
	
	

}
