package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Categoria;
import com.aprumed.SpringBootAprumed.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository cateRepo;
	
	public List<Categoria> listCategorias(){
		return cateRepo.findAll();
	}
	
	public Categoria addCategoria(Categoria categoria) {
		return cateRepo.save(categoria);
	}
	
	public Categoria getCategoriaById(int id) {
		return cateRepo.findById(id).get();
	}
	
	public void deleteCategoria(int id) {
		cateRepo.deleteById(id);
	}
	
}
