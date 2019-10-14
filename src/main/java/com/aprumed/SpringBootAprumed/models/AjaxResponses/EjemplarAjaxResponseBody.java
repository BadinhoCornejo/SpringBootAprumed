package com.aprumed.SpringBootAprumed.models.AjaxResponses;

import com.aprumed.SpringBootAprumed.models.Ejemplar;

public class EjemplarAjaxResponseBody {
	String msg;
	Ejemplar result;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Ejemplar getResult() {
		return result;
	}
	public void setResult(Ejemplar result) {
		this.result = result;
	}
}
