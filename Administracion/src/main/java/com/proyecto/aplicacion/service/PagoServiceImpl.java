package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.aplicacion.model.Pago;
import com.proyecto.aplicacion.repository.PagoRepository;

@Service
public class PagoServiceImpl implements PagoService {
	
	@Autowired
	private PagoRepository repositorio;
	
	@Override
	public List<Pago> consultarPagos() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Pago> consultarPagoPorId(Long codigoPago) {
		return repositorio.findById(codigoPago);
	}

	@Override
	public Pago crearPago(Pago pago) {
		return repositorio.save(pago);
	}

	@Override
	public void eliminarPago(Long codigoPago) {
		repositorio.deleteById(codigoPago);

	}

}