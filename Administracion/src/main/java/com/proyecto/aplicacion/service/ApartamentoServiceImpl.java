package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.aplicacion.model.Apartamento;
import com.proyecto.aplicacion.repository.ApartamentoRepository;

@Service
public class ApartamentoServiceImpl implements ApartamentoService{
	
	@Autowired
	private ApartamentoRepository repositorio;
	
	@Override
	public List<Apartamento> consultarApartamentos() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Apartamento> consultarApartamento(Long idApartamento) {
		return repositorio.findById(idApartamento);
	}

	@Override
	public Apartamento crearApartamento(Apartamento apartamento) {
		return repositorio.save(apartamento);
	}

	@Override
	public void eliminarApartamento(Long idApartamento) {
		repositorio.deleteById(idApartamento);
		
	}

}
