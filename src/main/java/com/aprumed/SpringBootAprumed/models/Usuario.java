package com.aprumed.SpringBootAprumed.models;

import java.io.Serializable;

import javax.persistence.*;

import com.aprumed.SpringBootAprumed.models.TipoUsuario;

@SuppressWarnings("serial")
@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario implements Serializable{
	private int usuarioID;
	private String apellido;
	private String nombre;
	private String email;
	private String usrPassword;
	private String estado;
	private String sexo;
	private String telefono;
	private TipoUsuario tipoUsuario;
	private Avatar avatar;

	@OneToOne()
	@JoinColumn(name = "avatarID")
	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	@ManyToOne()
	@JoinColumn(name = "tipousuarioID", referencedColumnName = "tipousuarioID")
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "usrpassword")
	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "usuarioID")
	public int getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
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

	@Column(name = "sexo")
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(name = "telefono")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
