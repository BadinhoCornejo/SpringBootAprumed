package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.Ejemplar;

public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer> {

}
