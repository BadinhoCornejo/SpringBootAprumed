package com.aprumed.SpringBootAprumed.controllers;

import java.awt.print.Pageable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.Ejemplar;
import com.aprumed.SpringBootAprumed.services.EjemplarService;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;

@Controller
public class HomeController {

	@Autowired
	EjemplarService ejemplarService;

	@Value("${application.controller.titulo}")
	private String titulo;

	@GetMapping("/")
	public String viewHomePage(Model model, HttpServletRequest request) {

		model.addAttribute("titulo", this.titulo);

		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		// Verifica si la sesión está invalidated y devuelve un anonymous true y usuario
		// null si no se ha iniciado sesión, devuelve false y un usuario si ya se
		// inición sesión
		UsuarioViewModel usr = verificarSession.verificarSession(request);

		// verificarSession(viewModel, donde va si no es admin, donde va si es admin,
		// debe redireccionar = true, es nombre de vista = false)
		String redirect = verificarSession.verificarPermiso(usr, "index", "/dashboard", false, true);

		List<Ejemplar> ejemplares = ejemplarService.listarLibros(PageRequest.of(0, 4));
		
		model.addAttribute("ejemplares", ejemplares);
		model.addAttribute("user", usr);

		return redirect;

	}

	@GetMapping("/signOut")
	public String signOut(HttpServletRequest request) {
		HttpSession mySession = (HttpSession) request.getSession(false);

		// Cerrar sesión
		mySession.invalidate();

		return "redirect:/";
	}

}
