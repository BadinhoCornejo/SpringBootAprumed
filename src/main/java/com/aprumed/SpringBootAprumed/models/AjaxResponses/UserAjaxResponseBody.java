package com.aprumed.SpringBootAprumed.models.AjaxResponses;

import com.aprumed.SpringBootAprumed.models.Usuario;

public class UserAjaxResponseBody {
	String msg;
	Usuario result;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Usuario getResult() {
		return result;
	}
	public void setResult(Usuario result) {
		this.result = result;
	}
}
