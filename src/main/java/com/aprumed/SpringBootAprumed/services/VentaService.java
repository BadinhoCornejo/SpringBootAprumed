package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Venta;
import com.aprumed.SpringBootAprumed.repositories.VentaRepository;

@Service
public class VentaService {

	
	@Autowired
	private VentaRepository ventaRepo;
	
	public List<Venta> listVentas(){
		return ventaRepo.findAll();
	}
	
	public Venta addVenta(Venta venta) {
		return ventaRepo.save(venta);
	}
	
	public Venta getVentaById(int id) {
		return ventaRepo.findById(id).get();
	}
	
	public void deleteVentaById(int id) {
		ventaRepo.deleteById(id);
	}
}
