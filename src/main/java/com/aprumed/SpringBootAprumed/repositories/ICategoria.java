package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.Categoria;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoria extends JpaRepository<Categoria, Integer> {

    @Query(value = "SELECT c.CategoriaID, c.Estado, c.NombreCategoria, count(*) as CANT " +
            "FROM ejemplar e inner join libro l on(e.LibroID=l.LibroID) " +
            "inner join categoria c on (l.CategoriaID=c.CategoriaID) " +
            "where c.Estado='Activo' AND (e.Estado='Activo' AND l.Estado='Activo') " +
            "group by c.CategoriaID " +
            "order by CANT desc ", nativeQuery = true)
    public List<Categoria> categoriasWithBooks();


}
