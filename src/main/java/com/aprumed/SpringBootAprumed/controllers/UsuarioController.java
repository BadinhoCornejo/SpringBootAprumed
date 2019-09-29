package com.aprumed.SpringBootAprumed.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.aprumed.SpringBootAprumed.models.Cuenta;
import com.aprumed.SpringBootAprumed.models.Usuario;
import com.aprumed.SpringBootAprumed.models.AjaxResponses.CuentaAjaxResponseBody;
import com.aprumed.SpringBootAprumed.models.AjaxResponses.UserAjaxResponseBody;
import com.aprumed.SpringBootAprumed.services.CuentaService;
import com.aprumed.SpringBootAprumed.services.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	CuentaService cuentaService;
	@Autowired
	UsuarioService usuarioService;

	@PostMapping(value = "/registrarCuenta")
	public ResponseEntity<Object> addAccount(@RequestBody Cuenta cuenta, Errors errors) {

		CuentaAjaxResponseBody result = new CuentaAjaxResponseBody();
				
		Usuario usr = usuarioService.getUsuarioByDni(cuenta.getUsuario().getDni());
		
		cuenta.setUsuario(usr);

		if (errors.hasErrors()) {

			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));

			return ResponseEntity.badRequest().body(result);

		}

		Cuenta acc = cuentaService.addCuenta(cuenta);
		
		if(acc == null) {
			result.setMsg("Error!");
		}
		else
		{
			result.setMsg("Success!");
		}
		
		result.setResult(acc);
		
		return ResponseEntity.ok(result);
		
	}

	@PostMapping(value = "/registrarUsuario")
	public ResponseEntity<Object> addUser(@RequestBody Usuario usuario, Errors errors) {
		
		UserAjaxResponseBody result = new UserAjaxResponseBody();
		
		

		if (errors.hasErrors()) {

			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));

			return ResponseEntity.badRequest().body(result);

		}

		Usuario usr = usuarioService.addUsuario(usuario);
		
		if(usr == null) {
			result.setMsg("Error!");
		}
		else
		{
			result.setMsg("Success!");
		}
		
		result.setResult(usr);
		
		return ResponseEntity.ok(result);
		
	}
}
