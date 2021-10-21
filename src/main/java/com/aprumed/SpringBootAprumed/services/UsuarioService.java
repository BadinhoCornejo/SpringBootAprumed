package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aprumed.SpringBootAprumed.models.Usuario;

import com.aprumed.SpringBootAprumed.repositories.IUsuario;

import javax.transaction.Transactional;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuario usrRepo;
	
	public List<Usuario> listUsuarios(){
		return usrRepo.findAll();
	}

	@Transactional
	public Usuario addUsuario(Usuario usuario) {
		return usrRepo.save(usuario);
	}
	
	public Usuario getUsuario(int id) {
		return usrRepo.findById(id).get();
	}

	
	public void deleteUsuario(int id) {
		usrRepo.deleteById(id);
	}
	
	public Usuario getUsuarioByEmail(String email) {
		return usrRepo.findByEmail(email);
	}
	
	public Usuario getUsuarioByEmailAndUsrPassword(String email, String usrpassword) {
		return usrRepo.findByEmailAndUsrpassword(email, usrpassword);
	}
}
