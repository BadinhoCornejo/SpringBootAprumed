package com.aprumed.SpringBootAprumed.restControllers;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.AjaxResponses.UserAjaxResponseBody;
import com.aprumed.SpringBootAprumed.models.Avatar;
import com.aprumed.SpringBootAprumed.models.TipoUsuario;
import com.aprumed.SpringBootAprumed.models.Usuario;
import com.aprumed.SpringBootAprumed.services.AvatarService;
import com.aprumed.SpringBootAprumed.services.TipoUsuarioService;
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

	@Autowired
	TipoUsuarioService tipoUsuarioService;

	@Autowired
	AvatarService avatarService;


	@GetMapping("tiposUsuario")
	public List<TipoUsuario> listTipoUsuario() { return tipoUsuarioService.listAll(); }


	@PostMapping(value = "new", consumes = "application/json", produces = "application/json")
	public Usuario addUser(@RequestBody Usuario usuario) {

		Avatar avatar = new Avatar();
		avatar.setAvatarID(1);

		usuario.setEstado("Activo");
		usuario.setAvatar(avatar);

		return usuarioService.addUsuario(usuario);

	}


	@PutMapping(value = "edit" , consumes = "application/json", produces = "application/json")
	public Usuario editarUsuario(@RequestBody Usuario usuario) {

		Usuario user = usuarioService.getUsuarioByEmail(usuario.getEmail());

			if(usuario.getAvatar().getNombreAvatar().equals("")){
				usuario.setAvatar(user.getAvatar());
			}

		return usuarioService.addUsuario(usuario);
	}


	@PostMapping(value = "buscarAvatar", consumes = "application/json", produces = "application/json")
	public Avatar buscarPortada(@RequestBody Avatar avatar)
	{

		return avatarService.getAvatarByName(avatar.getNombreAvatar());
	}

	@PostMapping(value = "addAvatar", consumes = "application/json", produces = "application/json")
	public Avatar addPortada(@RequestBody Avatar avatar)
	{
		if(avatar.getNombreAvatar().equals("")){
			return avatar;
		}

		Avatar _avatar = avatarService.getAvatarByName(avatar.getNombreAvatar());

		if(_avatar != null){
			avatar.setAvatarID(_avatar.getAvatarID());
		}

		return avatarService.addAvatar(avatar);
	}

	@PostMapping(value = "login", consumes = "application/json", produces = "application/json")
	public Usuario iniciarSession(@RequestBody Usuario usuario) {
		Usuario usr = usuarioService.getUsuarioByEmailAndUsrPassword(usuario.getEmail(), usuario.getUsrPassword());
		
		return usr;
	}

	@GetMapping(value = "verificarEmail/{email}")
	public Usuario verificarEmail(@PathVariable String email) throws UnsupportedEncodingException {

		String cleanEmail = URLDecoder.decode(email, "UTF-8");

		Usuario usr = usuarioService.getUsuarioByEmail(cleanEmail);

		return usr;
	}

	@GetMapping("/")
	public List<Usuario> listUsuario(){
		return usuarioService.listUsuarios();
	}

}
