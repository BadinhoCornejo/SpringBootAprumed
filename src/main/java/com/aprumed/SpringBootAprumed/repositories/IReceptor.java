package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.Receptor;

public interface IReceptor extends JpaRepository<Receptor, Integer> {

}
