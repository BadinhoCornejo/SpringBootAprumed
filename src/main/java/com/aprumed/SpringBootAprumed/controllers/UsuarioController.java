package com.aprumed.SpringBootAprumed.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aprumed.SpringBootAprumed.models.Usuario;
import com.aprumed.SpringBootAprumed.models.AjaxResponses.UserAjaxResponseBody;
import com.aprumed.SpringBootAprumed.services.UsuarioService;

@Controller
@SessionAttributes("user")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Value("${application.controller.titulo}")
	private String titulo;

	@PostMapping(value = "/registrarUsuario")
	public ResponseEntity<Object> addUser(@RequestBody Usuario usuario, Errors errors) {

		UserAjaxResponseBody result = new UserAjaxResponseBody();

		if (errors.hasErrors()) {

			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));

			return ResponseEntity.badRequest().body(result);

		}

		Usuario usr = usuarioService.addUsuario(usuario);

		if (usr == null) {
			result.setMsg("Error!");
		} else {
			result.setMsg("Success!");
		}

		result.setResult(usr);

		return ResponseEntity.ok(result);

	}

	@PostMapping(value = "/login")
	public ResponseEntity<Object> iniciarSession(@RequestBody Usuario usuario, Errors errors,
			HttpServletRequest request) {
		
		UserAjaxResponseBody result = new UserAjaxResponseBody();

		if (errors.hasErrors()) {

			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));

			return ResponseEntity.badRequest().body(result);

		}

		Usuario usr = usuarioService.getUsuarioByEmailAndUsrPassword(usuario.getEmail(), usuario.getUsrPassword());
		
		HttpSession mySession = null;
		
		if(usr!=null) {
			mySession = request.getSession(true);

			mySession.setAttribute("user", usr);
		}
		
		if (usr == null) {
			result.setMsg("Error!");
		} else {
			result.setMsg("Success!");
		}

		result.setResult(usr);

		return ResponseEntity.ok(result);

	}

	@PostMapping("/verificarEmail")
	public ResponseEntity<Object> verificarEmail(@RequestBody String email, Errors errors) throws UnsupportedEncodingException {

		String cleanEmail = URLDecoder.decode(email, "UTF-8");

		UserAjaxResponseBody result = new UserAjaxResponseBody();

		if (errors.hasErrors()) {

			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));

			return ResponseEntity.badRequest().body(result);

		}

		Usuario usr = usuarioService.getUsuarioByEmail(cleanEmail);

		if (usr == null) {
			result.setMsg("Error!");
		} else {
			result.setMsg("Success!");
		}

		result.setResult(usr);

		return ResponseEntity.ok(result);
	}

}
