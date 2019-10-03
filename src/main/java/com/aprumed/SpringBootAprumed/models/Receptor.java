package com.aprumed.SpringBootAprumed.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "receptor")
@Table(name = "receptor")
public class Receptor implements Serializable{
	
	private int receptorID;
	private String dni;
	private String apellido;
	private String nombre;
	private String telefono;
	private Venta venta;
	
	@OneToOne()
	@JoinColumn(name = "ventaID", referencedColumnName = "ventaID")
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	@Id
	@Column(name = "receptorID")
	public int getReceptorID() {
		return receptorID;
	}
	public void setReceptorID(int receptorID) {
		this.receptorID = receptorID;
	}
	
	@Column(name = "dni")
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@Column(name = "apellido")
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "telefono")
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
