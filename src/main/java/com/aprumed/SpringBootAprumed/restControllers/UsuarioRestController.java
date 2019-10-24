package com.aprumed.SpringBootAprumed.restControllers;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.AjaxResponses.UserAjaxResponseBody;
import com.aprumed.SpringBootAprumed.models.Avatar;
import com.aprumed.SpringBootAprumed.models.Usuario;
import com.aprumed.SpringBootAprumed.services.UsuarioService;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class UsuarioRestController {

	@Autowired
	UsuarioService usuarioService;

 
	@PostMapping(value = "add", consumes = "application/json", produces = "application/json")
	public Usuario addUser(@RequestBody Usuario usuario) {

		Usuario usr = usuarioService.addUsuario(usuario);

		return usr;
	}

	@PostMapping(value = "login", consumes = "application/json", produces = "application/json")
	public Usuario iniciarSession(@RequestBody Usuario usuario) {
		Usuario usr = usuarioService.getUsuarioByEmailAndUsrPassword(usuario.getEmail(), usuario.getUsrPassword());
		
		return usr;
	}

	@GetMapping(value = "verificarEmail/{email}")
	public Usuario verificarEmail(@PathVariable String email) throws UnsupportedEncodingException {

		String cleanEmail = URLDecoder.decode(email, "UTF-8");

		UserAjaxResponseBody result = new UserAjaxResponseBody();

		Usuario usr = usuarioService.getUsuarioByEmail(cleanEmail);

		return usr;

	}

	@GetMapping("/")
	public List<Usuario> listUsuario(){
		return usuarioService.listUsuarios();
	}

	
	@GetMapping(value = "search/{id}")
	public Usuario editarUsuarioGet(@PathVariable(value="id") int id) {
		return usuarioService.getUsuario(id);

	}

	@PutMapping(value = "editarUsuario", consumes = "application/json", produces = "application/json")
	public Usuario editarUsuarioPost(Usuario usuario, @RequestParam("idUsr") int usuarioID,
			@RequestParam("keyUsr") String clave, @RequestParam("avatUsr") int avatarID) {
		Avatar avatar = new Avatar();
		avatar.setAvatarID(avatarID);
		Usuario refUsuario = usuarioService.getUsuario(usuarioID);
		usuario.setUsuarioID(refUsuario.getUsuarioID());
		usuario.setUsrPassword(clave);
		usuario.setAvatar(avatar);
		return usuarioService.addUsuario(usuario);
	}
	
	@PutMapping(value = "eliminarUsuario/{id}")
	public Usuario eliminarUsuarioGet(@PathVariable(value="id") int id) {
		Usuario usuario = null;
		usuario = usuarioService.getUsuario(id);
		usuario.setEstado("Inactivo");
		usuarioService.addUsuario(usuario);
		return usuario;
	}
}
