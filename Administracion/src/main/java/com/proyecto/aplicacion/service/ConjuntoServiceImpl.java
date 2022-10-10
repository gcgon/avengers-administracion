package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.aplicacion.model.Conjunto;
import com.proyecto.aplicacion.repository.ConjuntoRepository;

@Service
public class ConjuntoServiceImpl implements ConjuntoService {
	
	@Autowired
	private ConjuntoRepository repositorio;

	@Override
	@Transactional
	public List<Conjunto> consultarConjuntos() {
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public Optional<Conjunto> consultarConjunto(Long nitConjunto) {
		return repositorio.findById(nitConjunto);
	}

	@Override
	@Transactional
	public Conjunto crearConjunto(Conjunto conjunto) {
		return repositorio.save(conjunto);
	}

	@Override
	@Transactional
	public void eliminarConjunto(Long nitConjunto) {
		repositorio.deleteById(nitConjunto);
	}

}
