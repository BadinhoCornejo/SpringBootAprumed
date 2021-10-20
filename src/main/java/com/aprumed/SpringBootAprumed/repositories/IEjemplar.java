package com.aprumed.SpringBootAprumed.repositories;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aprumed.SpringBootAprumed.models.Ejemplar;

public interface IEjemplar extends JpaRepository<Ejemplar, Integer> {

	public List<Ejemplar> findEjemplarByLibroLibroID(int libroID);

	public Ejemplar findBySku(String sku);

	@Query("SELECT e " +
			"FROM ejemplar e INNER JOIN libro l on(e.libro.libroID=l.libroID) " +
			"INNER JOIN categoria c on(l.categoria.categoriaID=c.categoriaID) " +
			"WHERE c.categoriaID=?1 AND (l.estado='Activo' AND e.estado='Activo') " +
			"group by l.isbn")
	public List<Ejemplar> ejemplaresByCategorie(int categorieID);

	@Query(value = "SELECT e FROM libro l INNER JOIN ejemplar e ON(l.libroID = e.libro.libroID) INNER JOIN portada p ON(l.portada.portadaID = p.portadaID)"
			+ " INNER JOIN categoria c ON(l.categoria.categoriaID = c.categoriaID) "
			+ "WHERE e.estado = 'Activo' GROUP BY l.isbn")
	public List<Ejemplar> listEjemplares();
	
	@Query(value = "SELECT e FROM libro l INNER JOIN ejemplar e ON(l.libroID = e.libro.libroID) INNER JOIN portada p ON(l.portada.portadaID = p.portadaID)"
			+ " INNER JOIN categoria c ON(l.categoria.categoriaID = c.categoriaID) "
			+ "WHERE e.estado = 'Activo' AND (l.titulo LIKE %?1% OR l.autor LIKE %?1% OR c.nombreCategoria LIKE %?1%)"
			+ "GROUP BY l.isbn")
	public List<Ejemplar> buscarLibroEjemplar(String parameter);
	
	@Query(value = "SELECT e FROM libro l INNER JOIN ejemplar e ON(l.libroID = e.libro.libroID) INNER JOIN portada p ON(l.portada.portadaID = p.portadaID)"
			+ " INNER JOIN categoria c ON(l.categoria.categoriaID = c.categoriaID) "
			+ "WHERE e.estado = 'Activo' AND c.categoriaID = ?1 GROUP BY l.isbn")
	public List<Ejemplar> listEjemplaresWithPaginationCategorie(int categoriaID, PageRequest pageable);

	@Query(value = "SELECT e, 1 FROM libro l INNER JOIN ejemplar e ON(l.libroID = e.libro.libroID) INNER JOIN portada p ON(l.portada.portadaID = p.portadaID)"
			+ " INNER JOIN categoria c ON(l.categoria.categoriaID = c.categoriaID) "
			+ "WHERE e.estado = 'Activo' AND e.libro.isbn = ?1 GROUP BY l.isbn ")
	public Ejemplar getOneEjemplar(String isbn);
}
