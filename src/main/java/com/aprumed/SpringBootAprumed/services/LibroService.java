package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Libro;
import com.aprumed.SpringBootAprumed.repositories.ILibro;

@Service
public class LibroService {

	@Autowired
	private ILibro libroRepo;
	
	public List<Libro> listLibros(){
		return libroRepo.findAll();
	}
	
	public Libro addLibro(Libro libro) {
		return libroRepo.save(libro);
	}

	public List<Libro> addLibros(List<Libro> libros){
		return libroRepo.saveAll(libros);
	}
	
	public Libro getLibroById(int id) {
		return libroRepo.findById(id).get();
	}

	public Libro getLibroByIsbn(String isbn) {return libroRepo.findByIsbn(isbn);}
	
	public void deleteLibroById(int id) {
		
		libroRepo.deleteById(id);
	}
	
	
}
