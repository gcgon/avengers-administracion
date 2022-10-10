package com.example.apartamento.services;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apartamento.model.apartamento;
import com.example.apartamento.repository.ApartamentoRepository;

@Service
public class ApartamentoServiceimpl implements ApartamentoService {
	@Autowired
	private ApartamentoRepository repositorio;
	
	@Override
	@Transactional
	public List<apartamento> consultarApartamentos() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	public Optional<apartamento> consultarApartamentos(Long id_apartamento) {
		// TODO Auto-generated method stub
		return repositorio.findById(id_apartamento);
	}

	@Override
	public apartamento guardarApartamentos(apartamento id_apartamento) {
		// TODO Auto-generated method stub
		return repositorio.save(id_apartamento);
	}


	@Override
	public void eliminaeApartamentos(Long id_apartamento) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id_apartamento);

	}

	@Override
	public Optional<apartamento> guardarApartamentos(Long id_apartamento) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<apartamento> guardararApartamentos(Long id_apartamento) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}

}
