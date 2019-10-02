package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Ejemplar;
import com.aprumed.SpringBootAprumed.repositories.EjemplarRepository;

@Service
public class EjemplarService {

	@Autowired
	private EjemplarRepository ejemplarRepo;
	
	public List<Ejemplar> listEjemplares(){
		return ejemplarRepo.findAll();
	}
	
	public Ejemplar addEjemplar(Ejemplar ejemplar) {
		return ejemplarRepo.save(ejemplar);
	}
	
	public Ejemplar getEjemplarById(int id) {
		return ejemplarRepo.findById(id).get();
	}
	
	public void deleteEjemplarById(int id) {
		ejemplarRepo.deleteById(id);
	}
	
}
