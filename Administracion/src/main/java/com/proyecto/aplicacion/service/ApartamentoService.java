package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.aplicacion.model.Apartamento;


public interface ApartamentoService {
	public List<Apartamento> consultarApartamentos();
	public Optional<Apartamento>consultarApartamento(Long idApartamento);
	public Apartamento crearApartamento(Apartamento apartamento);
	public void eliminarApartamento(Long idApartamento);
}
