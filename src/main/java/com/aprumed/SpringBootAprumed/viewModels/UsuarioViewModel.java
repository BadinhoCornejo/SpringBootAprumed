package com.aprumed.SpringBootAprumed.viewModels;

import com.aprumed.SpringBootAprumed.models.Usuario;

public class UsuarioViewModel {
	private Usuario usuario;
	private Boolean anonymous;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(Boolean anonymous) {
		this.anonymous = anonymous;
	}

	
}
