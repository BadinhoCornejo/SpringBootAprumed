package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.ComprobantePago;
import com.aprumed.SpringBootAprumed.repositories.ComprobantePagoRepository;

@Service
public class ComprobantePagoService {

	@Autowired
	private ComprobantePagoRepository cpRepo;
	
	public List<ComprobantePago> listCps(){
		return cpRepo.findAll();
	}
	
	public ComprobantePago addCp(ComprobantePago cp) {
		return cpRepo.save(cp);
	}
	
	public ComprobantePago getCpById(int id) {
		return cpRepo.findById(id).get();
	}
	
	public void deleteCpById(int id) {
		cpRepo.deleteById(id);
	}
}
