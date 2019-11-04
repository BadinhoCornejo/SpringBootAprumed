package com.aprumed.SpringBootAprumed.restControllers;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.AjaxResponses.EjemplarAjaxResponseBody;
import com.aprumed.SpringBootAprumed.models.AjaxResponses.PortadaAjaxResponseBody;
import com.aprumed.SpringBootAprumed.models.Categoria;
import com.aprumed.SpringBootAprumed.models.Ejemplar;
import com.aprumed.SpringBootAprumed.models.Libro;
import com.aprumed.SpringBootAprumed.models.Portada;
import com.aprumed.SpringBootAprumed.services.CategoriaService;
import com.aprumed.SpringBootAprumed.services.EjemplarService;
import com.aprumed.SpringBootAprumed.services.LibroService;
import com.aprumed.SpringBootAprumed.services.PortadaService;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.ls.LSException;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class LibroRestController {

	@Autowired
	private LibroService libroService;

	@Autowired
	private PortadaService portadaService;

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private EjemplarService ejemplarService;

	@GetMapping("/")
	public List<Libro> listaLibros(HttpServletRequest request) {

		List<Libro> libros = libroService.listLibros();

		return libros;

	}
	
	@GetMapping(value = "searchEjemplar/{parameter}")
	public List<Ejemplar> buscarLibro(@PathVariable("parameter") String parameter) {
		
		List<Ejemplar> results = ejemplarService.buscarLibroEjemplar(parameter);
		return results;
	}


	@PostMapping(value = "new", consumes = "application/json", produces = "application/json")
	public Libro nuevoLibroPost(@RequestBody Libro libro) {
		libro.setStock(0);
		libro.setEstado("Inactivo");

		return libroService.addLibro(libro);
	}

	@GetMapping(value = "search/{id}")
	public Libro editarLibroGet(@PathVariable int id){

		return libroService.getLibroById(id);
	}

	@PutMapping(value = "edit" , consumes = "application/json", produces = "application/json")
	public Libro editarLibroPost(@RequestBody Libro libro) {

		Libro _libro = libroService.getLibroByIsbn(libro.getIsbn());

		if(_libro != null){
			libro.setStock(_libro.getStock());
			libro.setLibroID(_libro.getLibroID());
			if(libro.getPortada() == null){
				libro.setPortada(_libro.getPortada());
			}
		}

		return libroService.addLibro(libro);
	}

	@PutMapping(value = "eliminarLibro/{id}", consumes = "application/json", produces = "application/json")
	public Libro eliminarLibro(@PathVariable(value = "id") int id) {
		Libro libro = null;
		libro = libroService.getLibroById(id);
		libro.setInactivo();
		return libroService.addLibro(libro);
	}

	@PutMapping(value = "deleteEjemplar", consumes = "application/json", produces = "application/json")
	public Libro eliminarEjemplar(@RequestBody List<Ejemplar> ejemplares){

		Libro libro = new Libro();

		for (Ejemplar ejemplar: ejemplares) {
			libro = ejemplar.libro;
		}

		ejemplarService.addEjemplares(ejemplares);

		List<Ejemplar> ejemplaresByLibro = ejemplarService.getEjemplaresByLibro(libro.getLibroID());

		libro.calcularStock(ejemplaresByLibro);

		return libroService.addLibro(libro);
	}
	
	@PostMapping(value = "addEjemplares", consumes = "application/json", produces = "application/json")
	public Libro agregarEjemplar(@RequestBody List<Ejemplar> ejemplares){

		Libro libro = new Libro();

		for (Ejemplar ejemplar : ejemplares) {
			ejemplar.setActivo();
			libro = libroService.getLibroById(ejemplar.libro.getLibroID());
		}

		ejemplarService.addEjemplares(ejemplares);

		List<Ejemplar> ejemplaresByLibro = ejemplarService.getEjemplaresByLibro(libro.getLibroID());

		libro.calcularStock(ejemplaresByLibro);

		return libroService.addLibro(libro);
	}

	@GetMapping("ejemplaresLibro/{libroID}")
	public List<Ejemplar> ejemplaresLibro(@PathVariable int libroID)
	{

		return ejemplarService.getEjemplaresByLibro(libroID);
	}

	@PostMapping(value = "buscarPortada", consumes = "application/json", produces = "application/json")
	public Portada buscarPortada(@RequestBody Portada portada)
	{

		return portadaService.getPortadaByNombrePortada(portada.getNombrePortada());
	}

	@PostMapping(value = "addPortada", consumes = "application/json", produces = "application/json")
	public Portada addPortada(@RequestBody Portada portada)
	{
		Portada _portada = portadaService.getPortadaByNombrePortada(portada.getNombrePortada());

		if(_portada != null){
			portada.setPortadaID(_portada.getPortadaID());
		}

		return portadaService.addPortada(portada);
	}
	
	@GetMapping("verLibro/{id}")
	public Ejemplar verLibro(@PathVariable int id) {

		Ejemplar ejemplar = ejemplarService.getEjemplarById(id);

		return ejemplar;
	}
}
