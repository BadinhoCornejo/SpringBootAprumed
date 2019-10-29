package com.aprumed.SpringBootAprumed.repositories;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aprumed.SpringBootAprumed.models.Ejemplar;

public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer> {

	public List<Ejemplar> findEjemplarByLibroLibroID(int libroID);

	public Ejemplar findBySku(String sku);

	@Query(value = "SELECT e FROM libro l INNER JOIN ejemplar e ON(l.libroID = e.libro.libroID) INNER JOIN portada p ON(l.portada.portadaID = p.portadaID)"
			+ " INNER JOIN categoria c ON(l.categoria.categoriaID = c.categoriaID) "
			+ "WHERE e.estado = 'Activo' GROUP BY l.isbn")
	public List<Ejemplar> listEjemplaresWithPagination(PageRequest pageable);
	
	@Query(value = "SELECT e FROM libro l INNER JOIN ejemplar e ON(l.libroID = e.libro.libroID) INNER JOIN portada p ON(l.portada.portadaID = p.portadaID)"
			+ " INNER JOIN categoria c ON(l.categoria.categoriaID = c.categoriaID) "
			+ "WHERE e.estado = 'Activo' AND (l.titulo LIKE %?1% OR l.autor LIKE %?1%)"
			+ "GROUP BY l.isbn")
	public List<Ejemplar> buscarLibroEjemplar(String parameter);
	
	@Query(value = "SELECT e FROM libro l INNER JOIN ejemplar e ON(l.libroID = e.libro.libroID) INNER JOIN portada p ON(l.portada.portadaID = p.portadaID)"
			+ " INNER JOIN categoria c ON(l.categoria.categoriaID = c.categoriaID) "
			+ "WHERE e.estado = 'Activo' AND c.categoriaID = ?1 GROUP BY l.isbn")
	public List<Ejemplar> listEjemplaresWithPaginationCategorie(int categoriaID, PageRequest pageable);
}
