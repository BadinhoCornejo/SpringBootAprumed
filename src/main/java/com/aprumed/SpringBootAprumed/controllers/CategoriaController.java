package com.aprumed.SpringBootAprumed.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aprumed.SpringBootAprumed.helpers.VerificarSessionHelper;
import com.aprumed.SpringBootAprumed.models.Categoria;
import com.aprumed.SpringBootAprumed.services.CategoriaService;
import com.aprumed.SpringBootAprumed.viewModels.UsuarioViewModel;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Value("${application.controller.titulo}")
	private String titulo;
	
	@RequestMapping(value = "/listaCategorias")
	public ModelAndView listCategoria(Model model, HttpServletRequest request){
		ModelAndView view=new ModelAndView();
		List<Categoria> lista = categoriaService.listCategorias();
		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificarSession.verificarSession(request);
		view.addObject("categorias",lista);
		view.setViewName(verificarSession.verificarPermiso(usr, "index", "categorias", false,false));
		view.addObject("user",usr);
		return view;
		
	}
	
	@GetMapping(value="/nuevaCategoria")
	public String crearCategoriaGet(Map<String, Object> model, HttpServletRequest request){
		Categoria categoria = new Categoria();
		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificarSession.verificarSession(request);
		String returnView=verificarSession.verificarPermiso(usr, "index", "newCategoria", false, false);
		model.put("categoria", categoria);
		model.put("user", usr);
		return returnView;
	}
	@PostMapping(value="/nuevaCategoria")
	public String crearCategoriaPost(Categoria categoria){
		categoria.setEstado("Activo");
		categoriaService.addCategoria(categoria);
		return "redirect:/listaCategorias";
	}
	
	@GetMapping(value="/editarCategoria/{id}")
	public String editarCategoriaGet(@PathVariable(value="id") int id, Map<String, Object> model, HttpServletRequest request) {
		Categoria categoria = null;
		Boolean estado;
		if(id>0) 
			categoria = categoriaService.getCategoriaById(id);
		else
			return "redirect:/listaCategoria";
		
		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		UsuarioViewModel usr = verificarSession.verificarSession(request);
		String returnView = verificarSession.verificarPermiso(usr, "index", "editCategoria", false, false);
		model.put("user", usr);
		model.put("categoria", categoria);
		if(categoria.getEstado().equals("Activo")) {
			model.put("estado","true");
		}
		else {
			model.put("estado","false");
		}
		return returnView;
	}
	
	@PostMapping(value="/editarCategoria")
	public String editarCategoriaPost(Categoria categoria, @RequestParam("idCat") int categoriaID) {
		Categoria refCategoria = categoriaService.getCategoriaById(categoriaID);
		categoria.setCategoriaID(refCategoria.getCategoriaID());
		/*if(categoria.g) {
			categoria.setActivo();
		}
		else {
			categoria.setInactivo();
		}*/
		categoriaService.addCategoria(categoria);
		return "redirect:/listaCategorias";
	}
	//@RequestParam("estadoCat")boolean estado
	
	@GetMapping(value="/eliminarCategoria/{id}")
	public String eliminarCategoriaGet(@PathVariable(value="id") int id, Map<String, Object> model, HttpServletRequest request) {
		VerificarSessionHelper verificarSession = new VerificarSessionHelper();
		Categoria categoria = null;
		String returnView;
		UsuarioViewModel usr;
		if(id>0){
			categoria = categoriaService.getCategoriaById(id);			
			categoria.setInactivo();
			usr = verificarSession.verificarSession(request);
			returnView = verificarSession.verificarPermiso(usr, "index", "categorias", false, false);
			categoriaService.addCategoria(categoria);
			model.put("user", usr);
			return "redirect:/listaCategorias";
		}
		else
			return "redirect:/listaCategorias";
	}

}
