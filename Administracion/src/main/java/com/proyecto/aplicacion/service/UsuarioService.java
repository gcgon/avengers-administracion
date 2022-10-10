package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.aplicacion.model.Usuario;

public interface UsuarioService {
	public List<Usuario> consultarUsuarios();
	public Optional<Usuario> consultarUsuarioPorId(Long id);
	public Usuario guardarUsuario(Usuario usuario);
	public void eliminarUsuario(Long id);
}