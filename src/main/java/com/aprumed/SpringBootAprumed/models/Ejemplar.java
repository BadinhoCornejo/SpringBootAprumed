package com.aprumed.SpringBootAprumed.models;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity(name = "ejemplar")
@Table(name = "ejemplar")
public class Ejemplar implements Serializable{
	public String sku;
	public String estado;
	public int ejemplarID;
	public Libro libro;

	@Column(name = "sku")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ejemplarID")
	public int getEjemplarID() {
		return ejemplarID;
	}

	public void setEjemplarID(int ejemplarID) {
		this.ejemplarID = ejemplarID;
	}

	@ManyToOne()
	@JoinColumn(name = "libroID", referencedColumnName = "libroID")
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public void setActivo() {
		this.estado = "Activo";
	}
	
	public void setInactivo() {
		this.estado = "Inactivo";
	}
	
	public void setVendido() {
		this.estado = "Vendido";
	}

	public void setEnCarrito() {
		this.estado = "En Carrito";
	}
}
