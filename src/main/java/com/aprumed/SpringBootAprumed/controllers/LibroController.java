package com.aprumed.SpringBootAprumed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.aprumed.SpringBootAprumed.services.LibroService;
import com.aprumed.SpringBootAprumed.services.PortadaService;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@Autowired
	private PortadaService portadaService;
	
	@GetMapping("/libros")
	public String listaLibros(Model model) {
		
	}
}
