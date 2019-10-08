package com.aprumed.SpringBootAprumed.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "portada")
@Table(name = "portada")
public class Portada implements Serializable{
	private int portadaID;
	private String estado;
	private String nombrePortada;
	private String url;
	
	@Id
	@Column(name = "portadaID")
	public int getPortadaID() {
		return portadaID;
	}
	public void setPortadaID(int portadaID) {
		this.portadaID = portadaID;
	}
	
	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name = "nombreportada")
	public String getNombrePortada() {
		return nombrePortada;
	}
	public void setNombrePortada(String nombrePortada) {
		this.nombrePortada = nombrePortada;
	}
	
	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
