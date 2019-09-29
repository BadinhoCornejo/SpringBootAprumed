package com.aprumed.SpringBootAprumed.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tipoUsuario")
@Table(name = "tipousuario")
public class TipoUsuario {
	private String nombreTipoUsuario;
	private String estado;
	private int tipoUsuarioID;

	@Column(name = "nombretipousuario")
	public String getNombreTipoUsuario() {
		return nombreTipoUsuario;
	}

	public void setNombreTipoUsuario(String nombreTipoUsuario) {
		this.nombreTipoUsuario = nombreTipoUsuario;
	}

	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Id
	@Column(name = "tipousuarioID")
	public int getTipoUsuarioID() {
		return tipoUsuarioID;
	}

	public void setTipoUsuarioID(int tipoUsuarioID) {
		this.tipoUsuarioID = tipoUsuarioID;
	}

}
