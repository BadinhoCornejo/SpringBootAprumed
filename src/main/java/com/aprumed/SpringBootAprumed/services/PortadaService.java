package com.aprumed.SpringBootAprumed.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Portada;
import com.aprumed.SpringBootAprumed.repositories.PortadaRepository;

@Service
public class PortadaService {

	@Autowired
	PortadaRepository portadaRepo;
	
	public Portada getPortadaByUrl(String url) {
		return portadaRepo.findByUrl(url);
	}
}
