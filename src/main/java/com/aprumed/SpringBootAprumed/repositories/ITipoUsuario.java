package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.TipoUsuario;

public interface ITipoUsuario extends JpaRepository<TipoUsuario, Integer>{
	
}
