package com.aprumed.SpringBootAprumed.repositories;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aprumed.SpringBootAprumed.models.Ejemplar;

public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer> {
	public Ejemplar findBySku(String sku);

	@Query(value = "SELECT e FROM libro l INNER JOIN ejemplar e ON(l.libroID = e.libro.libroID) INNER JOIN portada p ON(l.portada.portadaID = p.portadaID)"
			+ " INNER JOIN categoria c ON(l.categoria.categoriaID = c.categoriaID) "
			+ "WHERE e.estado = 'Activo' GROUP BY l.isbn")
	public List<Ejemplar> listEjemplaresWithPagination(PageRequest pageable);
}
