package com.aprumed.SpringBootAprumed.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "lineaventa")
@Table(name = "lineaventa")
public class LineaVenta {
	private int lineaVentaID;
	private Ejemplar ejemplar;
	private Venta venta;
	
	@Id
	@Column(name = "lineaventaID")
	public int getLineaVentaID() {
		return lineaVentaID;
	}
	public void setLineaVentaID(int lineaVentaID) {
		this.lineaVentaID = lineaVentaID;
	}
	
	@ManyToOne()
	@JoinColumn(name = "ejemplarID", referencedColumnName = "ejemplarID")
	public Ejemplar getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
	
	@ManyToOne()
	@JoinColumn(name = "ventaID", referencedColumnName = "ventaID")
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
	
}
