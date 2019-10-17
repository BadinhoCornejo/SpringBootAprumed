package com.aprumed.SpringBootAprumed.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.LineaVenta;

public interface LineaVentaRepository extends JpaRepository<LineaVenta, Integer> {
	public List<LineaVenta> findLineaVentaByVentaVentaID(int ventaID);
	public LineaVenta findLineaVentaByEjemplarEjemplarID(int ejemplarID);
}
