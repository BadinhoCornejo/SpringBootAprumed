package com.aprumed.SpringBootAprumed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@Value("${application.controller.titulo}")
	private String titulo;

	@GetMapping("/")
	public ModelAndView viewHomePage(Model model) {
		
		ModelAndView view = new ModelAndView("index");
		
		view.addObject("titulo", this.titulo);
		view.addObject("anonymous",true);
		view.addObject("user",null);
		
		return view;

	}
}
