package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.aplicacion.model.Usuario;
import com.proyecto.aplicacion.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repositorio;

	@Override
	@Transactional
	public List<Usuario> consultarUsuarios() {
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public Optional<Usuario> consultarUsuario(Long nroDocumento) {
		return repositorio.findById(nroDocumento);
	}

	@Override
	@Transactional
	public Usuario crearUsuario(Usuario usuario) {
		return repositorio.save(usuario);
	}

	@Override
	@Transactional
	public void eliminarUsuario(Long nroDocumento) {
		repositorio.deleteById(nroDocumento);
	}

}