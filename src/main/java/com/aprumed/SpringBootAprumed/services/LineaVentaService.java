package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.LineaVenta;
import com.aprumed.SpringBootAprumed.repositories.LineaVentaRepository;

@Service
public class LineaVentaService {

	@Autowired
	private LineaVentaRepository lineaVentaRepo;
	
	public List<LineaVenta> listLineasVenta(){
		return lineaVentaRepo.findAll();
	}
	
	public LineaVenta addLineaVenta(LineaVenta lineaVenta) {
		return lineaVentaRepo.save(lineaVenta);
	}
	
	public LineaVenta getLineaVentaById(int id) {
		return lineaVentaRepo.findById(id).get();
	}
	
	public void deleteLineaVentaById(int id) {
		lineaVentaRepo.deleteById(id);
	}
}
