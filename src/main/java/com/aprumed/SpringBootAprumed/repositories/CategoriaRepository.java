package com.aprumed.SpringBootAprumed.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	public List<Categoria> listCategorias();
	
	public Categoria addCategoria();
	
	//public void deleteCategoria(int id);

}
