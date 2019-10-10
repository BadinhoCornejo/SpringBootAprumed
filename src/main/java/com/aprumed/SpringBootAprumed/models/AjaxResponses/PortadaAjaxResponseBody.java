package com.aprumed.SpringBootAprumed.models.AjaxResponses;

import com.aprumed.SpringBootAprumed.models.Portada;

public class PortadaAjaxResponseBody {
	String msg;
	Portada result;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Portada getResult() {
		return result;
	}
	public void setResult(Portada result) {
		this.result = result;
	}
	
}
