package com.aprumed.SpringBootAprumed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aprumed.SpringBootAprumed.models.Usuario;
import com.aprumed.SpringBootAprumed.services.UsuarioService;

@Controller
public class HomeController {

	@Value("${application.controller.titulo}")
	private String titulo;

	@GetMapping("/")
	public String viewHomePage(Model model) {

		model.addAttribute("titulo", this.titulo);
		return "index";

	}
}
