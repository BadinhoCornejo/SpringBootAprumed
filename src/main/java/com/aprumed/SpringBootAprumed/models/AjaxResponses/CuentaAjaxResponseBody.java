package com.aprumed.SpringBootAprumed.models.AjaxResponses;

import com.aprumed.SpringBootAprumed.models.Cuenta;

public class CuentaAjaxResponseBody {
	String msg;
	Cuenta result;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Cuenta getResult() {
		return result;
	}
	public void setResult(Cuenta cuenta) {
		this.result = cuenta;
	}
}
