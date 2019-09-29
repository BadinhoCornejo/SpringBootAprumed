package com.aprumed.SpringBootAprumed.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Cuenta;
import com.aprumed.SpringBootAprumed.repositories.CuentaRepository;

@Service
public class CuentaService {

	@Autowired
	private CuentaRepository cuentaRepo;
	
	public Cuenta addCuenta(Cuenta cuenta) {
		return cuentaRepo.save(cuenta);
	}
}
