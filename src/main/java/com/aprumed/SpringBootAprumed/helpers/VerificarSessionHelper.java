package com.aprumed.SpringBootAprumed.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.aprumed.SpringBootAprumed.models.TipoUsuario;
import com.aprumed.SpringBootAprumed.models.Usuario;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;

public class VerificarSessionHelper {
	public UsuarioViewModel verificarSession(HttpServletRequest request) {

		HttpSession mySession = (HttpSession) request.getSession(false);
		UsuarioViewModel usr = new UsuarioViewModel();

		if (mySession == null) {

			usr.setAnonymous(true);
			usr.setUsuario(null);
		} else {
			usr.setUsuario((Usuario) mySession.getAttribute("user"));
			usr.setAnonymous(false);
		}

		return usr;
	}

	public String verificarPermiso(UsuarioViewModel usr, String notAdminGo, String adminGo, Boolean redirect,
			Boolean isRoot) {

		if (usr.getUsuario() == null) {
			return notAdminGo;
		}

		TipoUsuario tipUser = usr.getUsuario().getTipoUsuario();

		if (tipUser.getNombreTipoUsuario().equals("Cliente")) {
			if (redirect) {
				return "redirect:" + notAdminGo;
			}
			return notAdminGo;
		}

		if (isRoot) {
			return "redirect:" + adminGo;
		}

		return adminGo;

	}
}
