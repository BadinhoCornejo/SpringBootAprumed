package com.aprumed.SpringBootAprumed.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "categoria")
@Table(name = "categoria")
public class Categoria implements Serializable{

	private int categoriaID;
	private String nombreCategoria;
	private String estado;
	
	@Id
	@Column(name = "categoriaID")
	public int getCategoriaID() {
		return categoriaID;
	}
	public void setCategoriaID(int categoriaID) {
		this.categoriaID = categoriaID;
	}
	
	@Column(name = "nombrecategoria")
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
