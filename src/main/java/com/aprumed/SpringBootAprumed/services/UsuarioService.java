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
	
	public List<Usuario> listUsers(){
		return usrRepo.listUsers();
	}
	
	public List<Usuario> listAll(){
		return usrRepo.findAll();
	}
	
	public Usuario addUsuario(Usuario usuario) {
		return usrRepo.save(usuario);
	}
	
	public Usuario getUsuario(int id) {
		return usrRepo.findById(id).get();
	}
	
	public Usuario getUsuarioByDni(String dni) {
		return usrRepo.findByDni(dni);
	}
	
	public void deleteUsuario(int id) {
		usrRepo.deleteById(id);
	}
	
	
}
