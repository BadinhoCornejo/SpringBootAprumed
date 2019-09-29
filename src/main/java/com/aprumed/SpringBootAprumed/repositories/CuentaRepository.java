package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aprumed.SpringBootAprumed.models.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}
