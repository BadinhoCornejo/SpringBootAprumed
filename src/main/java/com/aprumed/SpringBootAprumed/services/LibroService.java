package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Libro;
import com.aprumed.SpringBootAprumed.repositories.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepo;
	
	public List<Libro> listLibros(){
		return libroRepo.findAll();
	}
	
	public Libro addLibro(Libro libro) {
		return libroRepo.save(libro);
	}
	
	public Libro getLibroById(int id) {
		return libroRepo.findById(id).get();
	}
	
	public void deleteLibroById(int id) {
		
		libroRepo.deleteById(id);
	}
	
	
}
