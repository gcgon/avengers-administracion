/**
 * 
 */
package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.aplicacion.model.Usuario;
import com.proyecto.aplicacion.repository.UsuarioRepository;

/**
 * @author Miguel Ángel Reinosa Quintero
 *
 */

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
	public Optional<Usuario> consultarUsuarioPorId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	@Transactional
	public Usuario guardarUsuario(Usuario usuario) {
		return repositorio.save(usuario);
	}

	@Override
	@Transactional
	public void eliminarUsuario(Long id) {
		repositorio.deleteById(id);
	}

}
