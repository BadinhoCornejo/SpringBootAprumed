package com.aprumed.SpringBootAprumed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aprumed.SpringBootAprumed.models.Categoria;
import com.aprumed.SpringBootAprumed.services.CategoriaService;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Value("${application.controller.titulo}")
	private String titulo;
	
	@GetMapping(value = "/listaCategorias")
	public ModelAndView listCategoria(Model model){
		ModelAndView view=new ModelAndView();
		
		List<Categoria> lista = categoriaService.listCategorias();
		
		view.addObject("categorias",lista);
		view.setViewName("categorias");
		return view;
		
	}

}
