package com.aprumed.SpringBootAprumed.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;

@Controller
public class HomeController {

	@Value("${application.controller.titulo}")
	private String titulo;

	@GetMapping("/")
	public ModelAndView viewHomePage(Model model, HttpServletRequest request) {

		ModelAndView view = new ModelAndView();

		view.addObject("titulo", this.titulo);

		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		// Verifica si la sesión está invalidated y devuelve un anonymous true y usuario
		// null si no se ha iniciado sesión, devuelve false y un usuario si ya se
		// inición sesión
		UsuarioViewModel usr = verificarSession.verificarSession(request);
		
		// verificarSession(viewModel, donde va si no es admin, donde va si es admin,
		// debe redireccionar = true, es nombre de vista = false)
		view.setViewName(verificarSession.verificarPermiso(usr, "index", "dashboard", false));

		view.addObject("user", usr);

		return view;

	}

	@GetMapping("/signOut")
	public String signOut(HttpServletRequest request) {
		HttpSession mySession = (HttpSession) request.getSession(false);

		//Cerrar sesión
		mySession.invalidate();
		
		return "redirect:/";
	}

}
