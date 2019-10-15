package com.aprumed.SpringBootAprumed.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aprumed.SpringBootAprumed.models.ComprobantePago;

public interface ComprobantePagoRepository extends JpaRepository<ComprobantePago, Integer> {
	
	@Query(value = "SELECT cp FROM comprobantepago cp INNER JOIN venta v "
			+ "ON(cp.venta.ventaID = v.ventaID) "
			+ "WHERE v.estado = 'Realizada' AND v.usuario.usuarioID = ?1 ")
	public List<ComprobantePago> getLastCP(int usuarioID);
}
