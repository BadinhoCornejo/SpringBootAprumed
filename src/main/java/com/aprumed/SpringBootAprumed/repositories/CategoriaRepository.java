package com.aprumed.SpringBootAprumed.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	//@Query("update Categoria Set NombreCategoria=
//			+ "select u from usuario u inner join avatar a on(u.avatar = a.avatarID) where u.email = ?1 and u.usrPassword = ?2")
	//public void updateCategoria(Categoria categoria);
}
