package com.aprumed.SpringBootAprumed.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Portada;
import com.aprumed.SpringBootAprumed.repositories.IPortada;

@Service
public class PortadaService {

	@Autowired
    IPortada portadaRepo;
	
	public Portada getPortadaByUrl(String url) {
		return portadaRepo.findByUrl(url);
	}
	public Portada getPortadaByNombrePortada(String nombrePotada) {
		return portadaRepo.findByNombrePortada(nombrePotada);
	}
	public Portada addPortada(Portada portada){return portadaRepo.save(portada);};
}
