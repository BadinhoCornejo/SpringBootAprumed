package com.aprumed.SpringBootAprumed.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aprumed.SpringBootAprumed.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query("SELECT usr.usuarioID, usr.username, usr.apellido, usr.nombre, usr.sexo, usr.telefono, tipUsr.nombreTipoUsuario,usr.email,usr.estado,usr.usrPassword,"
			+ "tipUsr.estado, tipUsr.tipoUsuarioID  "
			+ "FROM usuario usr inner join tipoUsuario tipUsr " + "on(usr.tipoUsuario.tipoUsuarioID = tipUsr.tipoUsuarioID)")
	public List<Usuario> listUsers();
	
	public Usuario findByUsername(String username);

}
