package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.ComprobantePago;
import com.aprumed.SpringBootAprumed.repositories.IComprobantePago;

@Service
public class ComprobantePagoService {

	@Autowired
	private IComprobantePago cpRepo;
	
	public List<ComprobantePago> listCps(){
		return cpRepo.findAll();
	}
	
	public ComprobantePago addCp(ComprobantePago cp) {
		return cpRepo.save(cp);
	}
	
	public ComprobantePago getCpById(int id) {
		return cpRepo.findById(id).get();
	}
	
	public List<ComprobantePago> getLastCP(int usuarioID) {
		return cpRepo.getLastCP(usuarioID);
	}
	
	public void deleteCpById(int id) {
		cpRepo.deleteById(id);
	}
}
