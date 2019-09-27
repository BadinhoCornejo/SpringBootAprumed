package com.aprumed.SpringBootAprumed.models;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Cuenta {
	private int cuentaID;
	@OneToOne
	@JoinColumn(name = "UsuarioID", referencedColumnName = "UsuarioID")
	private Usuario usuario;
	private String email;
	private String usrPassword;
	private String estado;
	public int getCuentaID() {
		return cuentaID;
	}
	public void setCuentaID(int cuentaID) {
		this.cuentaID = cuentaID;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsrPassword() {
		return usrPassword;
	}
	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
