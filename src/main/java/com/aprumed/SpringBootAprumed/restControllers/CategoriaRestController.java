package com.aprumed.SpringBootAprumed.restControllers;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.Categoria;
import com.aprumed.SpringBootAprumed.services.CategoriaService;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categories")
public class CategoriaRestController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/")
	public List<Categoria> listCategoria(){
		return categoriaService.listCategorias();
	}

	@PostMapping(value="new", consumes = "application/json", produces = "application/json")
	public Categoria crearCategoriaPost(@RequestBody Categoria categoria){
		categoria.setActivo();
		return categoriaService.addCategoria(categoria);
	}

	@PutMapping(value="edit", consumes = "application/json", produces = "application/json")
	public Categoria editarCategoriaPost(@RequestBody Categoria categoria) {
		return categoriaService.addCategoria(categoria);
	}
	


}
