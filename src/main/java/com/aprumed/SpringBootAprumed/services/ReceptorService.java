package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Receptor;
import com.aprumed.SpringBootAprumed.repositories.IReceptor;

@Service
public class ReceptorService {

	@Autowired
	private IReceptor receptorRepo;
	
	public List<Receptor> listReceptores(){
		return receptorRepo.findAll();
	}
	
	public Receptor addReceptor(Receptor receptor) {
		return receptorRepo.save(receptor);
	}
	
	public Receptor getReceptorById(int id) {
		return receptorRepo.findById(id).get();
	}
	
	public void deleteReceptorById(int id) {
		receptorRepo.deleteById(id);
	}
	
}
