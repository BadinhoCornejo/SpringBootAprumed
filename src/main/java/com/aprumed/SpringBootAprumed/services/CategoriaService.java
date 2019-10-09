package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Categoria;
import com.aprumed.SpringBootAprumed.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listCategorias(){
		return categoriaRepository.findAll();
	}
	
	public Categoria addCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria getCategoriaById(int id) {
		return categoriaRepository.findById(id).get();
	}
	
	public void deleteCategoria(int id) {
		categoriaRepository.deleteById(id);
	}
	
	/*public void updateCategoria(Categoria categoria) {
		categoriaRepository.(categoria);
	}*/
	
}
