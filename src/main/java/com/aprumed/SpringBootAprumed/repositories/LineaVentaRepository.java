package com.aprumed.SpringBootAprumed.repositories;

import java.util.List;

import com.aprumed.SpringBootAprumed.models.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.LineaVenta;
import org.springframework.data.jpa.repository.Query;

public interface LineaVentaRepository extends JpaRepository<LineaVenta, Integer> {
	public List<LineaVenta> findLineaVentaByVentaVentaID(int ventaID);
	public LineaVenta findLineaVentaByEjemplarEjemplarID(int ejemplarID);
	@Query(value = "SELECT e, count(e) FROM lineaventa lv inner join ejemplar e on(lv.ejemplar.ejemplarID = e.ejemplarID) " +
			"inner join libro l on(e.libro.libroID = l.libroID) inner join venta v on(lv.venta.ventaID = v.ventaID)"
			+ "WHERE v.usuario.usuarioID = ?1 and v.estado ='Activo' GROUP BY l.isbn")
	public List<Ejemplar> getEjemplaresGroup(int usuarioID);

	@Query(value = "SELECT count(e) FROM lineaventa lv inner join ejemplar e on(lv.ejemplar.ejemplarID = e.ejemplarID) " +
			"inner join libro l on(e.libro.libroID = l.libroID) inner join venta v on(lv.venta.ventaID = v.ventaID) "
			+ "WHERE v.usuario.usuarioID = ?1 and l.isbn = ?2 and v.estado ='Activo' GROUP BY l.isbn")
	public int getCantidadPorProducto(int usuarioID, String isbn);
}
