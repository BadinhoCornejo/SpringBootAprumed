package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
	
}
