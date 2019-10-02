package com.aprumed.SpringBootAprumed.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ejemplar")
@Table(name = "ejemplar")
public class Ejemplar {
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

}
