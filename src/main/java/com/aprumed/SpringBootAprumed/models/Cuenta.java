package com.aprumed.SpringBootAprumed.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "cuenta")
@Table(name = "cuenta")
public class Cuenta {
	private int cuentaID;

	private String email;
	private String usrPassword;
	private String estado;
	private Usuario usuario;

	@OneToOne()
	@JoinColumn(name = "usuarioID", referencedColumnName = "usuarioID")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Id
	@Column(name = "cuentaID")
	public int getCuentaID() {
		return cuentaID;
	}

	public void setCuentaID(int cuentaID) {
		this.cuentaID = cuentaID;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "usrpassword")
	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}
	
	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
