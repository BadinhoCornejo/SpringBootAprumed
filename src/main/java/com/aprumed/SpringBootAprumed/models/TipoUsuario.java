package com.aprumed.SpringBootAprumed.models;

public class TipoUsuario {
	private String nombreTipoUsuario;
	private String estado;
	private int tipoUsuarioID;
	
	public String getNombreTipoUsuario() {
		return nombreTipoUsuario;
	}
	public void setNombreTipoUsuario(String nombreTipoUsuario) {
		this.nombreTipoUsuario = nombreTipoUsuario;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getTipoUsuarioID() {
		return tipoUsuarioID;
	}
	public void setTipoUsuarioID(int tipoUsuarioID) {
		this.tipoUsuarioID = tipoUsuarioID;
	}

	
	
	
}
