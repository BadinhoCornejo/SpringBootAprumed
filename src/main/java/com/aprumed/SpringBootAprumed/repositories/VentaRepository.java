package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aprumed.SpringBootAprumed.models.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
	
	@Query(value = "SELECT v FROM venta v INNER JOIN usuario u ON(v.usuario.usuarioID = u.usuarioID) "
			+ "WHERE v.estado = 'Activo' AND u.usuarioID = ?1")
	public Venta getVentaByUserAndState(int usuarioID);
}
