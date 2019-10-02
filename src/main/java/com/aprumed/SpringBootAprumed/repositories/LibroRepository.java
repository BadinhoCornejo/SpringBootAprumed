package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
