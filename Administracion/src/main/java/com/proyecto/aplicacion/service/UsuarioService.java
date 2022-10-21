package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.aplicacion.model.Usuario;


public interface UsuarioService {
	public Optional<Usuario>consultarUsuario(Long nroDocumento);
	public List<Usuario>consultarAdminUser(Long nroDocumento, String clave);
	public List<Usuario> consultarUsuarios();
	public Usuario crearUsuario(Usuario usuario);
	public void eliminarUsuario(Long nroDocumento);
}
