package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.Libro;

public interface ILibro extends JpaRepository<Libro, Integer>{
    public Libro findByIsbn(String isbn);
}
