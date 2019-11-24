package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Categoria;
import com.aprumed.SpringBootAprumed.repositories.ICategoria;

@Service
public class CategoriaService {
	@Autowired
	private ICategoria categoriaRepository;
	
	public List<Categoria> listCategorias(){
		return categoriaRepository.findAll();
	}
	
	public Categoria addCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria getCategoriaById(int id) {
		return categoriaRepository.findById(id).get();
	}

	public List<Categoria> categoriasWithBooks(){ return categoriaRepository.categoriasWithBooks();}

}
