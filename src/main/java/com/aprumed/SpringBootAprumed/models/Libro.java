package com.aprumed.SpringBootAprumed.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity(name = "libro")
@Table(name = "libro")
public class Libro implements Serializable{

	private int libroID;
	private String autor;
	private String fechaPublicacion;
	private String isbn;
	private Double precio;
	private int stock;
	private String titulo;
	private Categoria categoria;
	private String estado;
	private Portada portada;

	@OneToOne()
	@JoinColumn(name = "portadaID")
	public Portada getPortada() {
		return portada;
	}

	public void setPortada(Portada portada) {
		this.portada = portada;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "libroID")
	public int getLibroID() {
		return libroID;
	}

	public void setLibroID(int libroID) {
		this.libroID = libroID;
	}

	@Column(name = "autor")
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Column(name = "fechapublicacion")
	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	@Column(name = "isbn")
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "precio")
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Column(name = "stock")
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Column(name = "titulo")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@ManyToOne()
	@JoinColumn(name = "categoriaID", referencedColumnName = "categoriaID")
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void addStock() {
		this.stock = this.stock + 1;
	}
	
	public void quitStock() {
		this.stock = this.stock - 1;
	}
	
	public void setActivo() {
		this.estado = "Activo";
	}
	
	public void setInactivo() {
		this.estado = "Inactivo";
	}
	
	public void verificarStock() {
		if(this.stock <= 0) {
			this.setInactivo();
		}
		else
		{
			this.setActivo();
		}
	}

}
