package com.aprumed.SpringBootAprumed.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.aprumed.SpringBootAprumed.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {


	@Modifying
	@Query("update categoria c set c.nombreCategoria = ?1 where c.categoriaID = ?2")
	public void updateCategoria(String nombreCategoria,int categoriaID);
}
