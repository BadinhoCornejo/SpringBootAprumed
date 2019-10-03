package com.aprumed.SpringBootAprumed.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "venta")
@Table(name = "venta")
public class Venta implements Serializable{
	private int ventaID;
	private String estado;
	private String fechaVenta;
	private String horaVenta;
	private Usuario usuario;

	@ManyToOne()
	@JoinColumn(name = "usuarioID", referencedColumnName = "usuarioID")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Id
	@Column(name = "ventaID")
	public int getVentaID() {
		return ventaID;
	}

	public void setVentaID(int ventaID) {
		this.ventaID = ventaID;
	}

	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name = "fechaventa")
	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	@Column(name = "horaventa")
	public String getHoraVenta() {
		return horaVenta;
	}

	public void setHoraVenta(String horaVenta) {
		this.horaVenta = horaVenta;
	}

}
