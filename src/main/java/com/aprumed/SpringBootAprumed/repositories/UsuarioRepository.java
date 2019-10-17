package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aprumed.SpringBootAprumed.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	public Usuario findByEmail(String email);
	
	@Query("select u from usuario u inner join avatar a on(u.avatar = a.avatarID) where u.email = ?1 and u.usrPassword = ?2")
	public Usuario findByEmailAndUsrpassword(String email, String usrpassword);

}
