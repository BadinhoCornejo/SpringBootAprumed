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
@RequestMapping("/cateogires")
public class CategoriaRestController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/")
	public List<Categoria> listCategoria(Model model){
		List<Categoria> lista = categoriaService.listCategorias();
		return lista;
	}

	@PostMapping(value="new", consumes = "application/json", produces = "application/json")
	public Categoria crearCategoriaPost(@RequestBody Categoria categoria){
		categoria.setEstado("Activo");
		return categoriaService.addCategoria(categoria);
	}
	
	@GetMapping(value="search/{id}")
	public Categoria editarCategoriaGet(@PathVariable(value="id") int id, @RequestBody Categoria categoria) {
		return categoriaService.getCategoriaById(id);
	}
	
	@PutMapping(value="edit/{id}", consumes = "application/json", produces = "application/json")
	public Categoria editarCategoriaPost(Categoria categoria, @PathVariable(value="id") int id) {
		Categoria refCategoria = categoriaService.getCategoriaById(id);
		categoria.setCategoriaID(refCategoria.getCategoriaID());
		return categoriaService.addCategoria(categoria);
	}
	
	@PutMapping(value="delete/{id}", consumes = "application/json", produces = "application/json")
	public Categoria eliminarCategoriaGet(@PathVariable(value="id") int id, Map<String, Object> model) {

		Categoria categoria = null;

		categoria = categoriaService.getCategoriaById(id);
		categoria.setInactivo();

		return categoriaService.addCategoria(categoria);

	}

}
