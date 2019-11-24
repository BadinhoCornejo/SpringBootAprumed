package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aprumed.SpringBootAprumed.models.Portada;

public interface IPortada extends JpaRepository<Portada, Integer>{
	public Portada findByUrl(String url);
	public Portada findByNombrePortada(String nombrePortada);
}
