package com.aprumed.SpringBootAprumed.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "avatar")
@Table(name = "avatar")
public class Avatar implements Serializable{
	private int avatarID;
	private String estado;
	private String nombreAvatar;
	private String url;
	
	@Id
	@Column(name = "avatarID")
	public int getAvatarID() {
		return avatarID;
	}
	public void setAvatarID(int avatarID) {
		this.avatarID = avatarID;
	}
	
	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name = "nombreavatar")
	public String getNombreAvatar() {
		return nombreAvatar;
	}
	public void setNombreAvatar(String nombreAvatar) {
		this.nombreAvatar = nombreAvatar;
	}
	
	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
