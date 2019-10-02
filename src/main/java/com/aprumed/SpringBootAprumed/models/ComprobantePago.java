package com.aprumed.SpringBootAprumed.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "comprobantepago")
@Table(name = "comprobantepago")
public class ComprobantePago {
	private String fechaCp;
	private String horaCp;
	private String ruc;
	private Double subtotal;
	private Venta venta;
	private int comprobantePagoID;

	@Id
	@Column(name = "comprobantepagoID")
	public int getComprobantePagoID() {
		return comprobantePagoID;
	}

	public void setComprobantePagoID(int comprobantePagoID) {
		this.comprobantePagoID = comprobantePagoID;
	}

	@Column(name = "fechacp")
	public String getFechaCp() {
		return fechaCp;
	}

	public void setFechaCp(String fechaCp) {
		this.fechaCp = fechaCp;
	}

	@Column(name = "horacp")
	public String getHoraCp() {
		return horaCp;
	}

	public void setHoraCp(String horaCp) {
		this.horaCp = horaCp;
	}

	@Column(name = "ruc")
	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	@Column(name = "subtotal")
	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	@OneToOne()
	@JoinColumn(name = "ventaID", referencedColumnName = "ventaID")
	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}
