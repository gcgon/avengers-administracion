package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.aplicacion.model.Usuario;


public interface UsuarioService {
	public List<Usuario> consultarFacturas();
	public Optional<Usuario>consultarFacturaById(Long nroDocumento);
	public Usuario crearFactura(Usuario usuario);
	public void eliminarFacturaById(Long nroDocumento);
}
