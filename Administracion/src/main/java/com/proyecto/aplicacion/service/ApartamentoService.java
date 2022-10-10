package com.example.apartamento.services;

import java.util.List;
import java.util.Optional;

import com.example.apartamento.model.apartamento;

public interface ApartamentoService {
	public List<apartamento> consultarApartamentos();
	public Optional<apartamento> guardarApartamentos (Long id_apartamento);
	public apartamento guardarApartamentos(apartamento id_apartamento);
	public Optional<apartamento> guardararApartamentos (Long id_apartamento);
	public void eliminaeApartamentos (Long id_apartamento);
}
