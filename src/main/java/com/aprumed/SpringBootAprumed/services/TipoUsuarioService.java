package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.TipoUsuario;
import com.aprumed.SpringBootAprumed.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {
	
	@Autowired
	TipoUsuarioRepository tipoUsuarioRepo;
	
	public List<TipoUsuario> listAll(){
		return tipoUsuarioRepo.findAll();
	}
	
}
