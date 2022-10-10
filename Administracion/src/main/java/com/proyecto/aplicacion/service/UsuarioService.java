package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.aplicacion.model.Usuario;


public interface UsuarioService {
	public List<Usuario> consultarUsuarios();
	public Optional<Usuario>consultarUsuario(Long nroDocumento);
	public Usuario crearUsuario(Usuario usuario);
	public void eliminarUsuario(Long nroDocumento);
}
