package com.aprumed.SpringBootAprumed.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.Usuario;
import com.aprumed.SpringBootAprumed.models.AjaxResponses.UserAjaxResponseBody;
import com.aprumed.SpringBootAprumed.services.UsuarioService;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;



@Controller
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
	
	@RequestMapping(value = "/listaUsuarios")
	public ModelAndView listUsuario(Model model, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		List<Usuario> lista = usuarioService.listUsuarios();
		VerificarSessionHelper verificaSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificaSession.verificarSession(request);
		view.addObject("usuarios",lista);
		view.setViewName(verificaSession.verificarPermiso(usr, "index", "usuarios", false, false));
		view.addObject("user", usr);
		return view;
	}

}
