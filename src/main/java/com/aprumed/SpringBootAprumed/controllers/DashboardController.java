package com.aprumed.SpringBootAprumed.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.TipoUsuario;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;

@Controller
public class DashboardController {
	@GetMapping("/dashboard")
	public String viewHomePage(Model model, HttpServletRequest request) {

		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificarSession.verificarSession(request);

		model.addAttribute("user", usr);

		return verificarSession.verificarPermiso(usr, "/", "dashboard",true);

	}
}
