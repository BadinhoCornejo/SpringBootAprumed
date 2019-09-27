package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aprumed.SpringBootAprumed.models.Usuario;

import com.aprumed.SpringBootAprumed.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usrRepo;
	
	public List<Usuario> listAll(){
		return usrRepo.findAll();
	}
	
	public void addUsuario(Usuario usuario) {
		usrRepo.save(usuario);
	}
	
	public Usuario getUsuario(int id) {
		return usrRepo.findById(id).get();
	}
	
	public void deleteUsuario(int id) {
		usrRepo.deleteById(id);
	}
}
