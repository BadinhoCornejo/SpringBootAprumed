package com.aprumed.SpringBootAprumed.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aprumed.SpringBootAprumed.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public Usuario findByUsername(String username);
	public Usuario findByEmail(String email);
	
	@Query("select u from usuario u where u.email = ?1 and u.usrPassword = ?2")
	public Usuario findByEmailAndUsrpassword(String email, String usrpassword);

}
