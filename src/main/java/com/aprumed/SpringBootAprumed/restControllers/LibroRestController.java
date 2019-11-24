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
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/api/books")
public class LibroRestController {

	@Autowired
	private LibroService libroService;

	@Autowired
	private PortadaService portadaService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private EjemplarService ejemplarService;

	//Listar los ejemplares en la pagina principal
	@GetMapping("mainEjemplares/{i}")
	public List<Ejemplar> mainEjemplares(@PathVariable int i){
		List<Ejemplar> ejemplares = ejemplarService.listarLibros( PageRequest.of(i, 8));
		return ejemplares;
	}

	@GetMapping("ejemplaresByCategoria/{i}")
	public List<Ejemplar> ejemplaresByCategoria(@PathVariable int i){
		return ejemplarService.ejemplaresPorCategoria(i);
	}

	//Ver detalle de un libro
	@GetMapping("verLibro/{libroID}")
	public Ejemplar verLibro(@PathVariable int libroID) {

		Ejemplar ejemplar = ejemplarService.getEjemplarById(libroID);

		return ejemplar;
	}

	//Para la barra de búsqueda
	@GetMapping(value = "searchEjemplar/{parameter}")
	public List<Ejemplar> buscarLibro(@PathVariable("parameter") String parameter) {

		List<Ejemplar> results = ejemplarService.buscarLibroEjemplar(parameter);
		return results;
	}

	@PutMapping(value = "deleteEjemplar", consumes = "application/json", produces = "application/json")
	public Libro eliminarEjemplar(@RequestBody List<Ejemplar> ejemplares){

		Libro libro = new Libro();

		//libro = ejemplares.get(0).getLibro(); Check this
		
		for (Ejemplar ejemplar: ejemplares) {
			libro = ejemplar.libro;
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
}
