package com.proyecto.aplicacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.aplicacion.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query(value = "SELECT * FROM usuario u WHERE u.nro_documento_usuario = :nroDocumento AND u.clave= :clave" , nativeQuery = true)
	public List<Usuario> consultarAdminUser(Long nroDocumento, String clave);
}
