package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.aplicacion.model.Conjunto;


public interface ConjuntoService {
	public List<Conjunto> consultarConjuntos();
	public Optional<Conjunto>consultarConjunto(Long nitConjunto);
	public Conjunto crearConjunto(Conjunto conjunto);
	public void eliminarConjunto(Long nitConjunto);
}
