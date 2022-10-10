package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.aplicacion.model.Pago;
import com.proyecto.aplicacion.repository.PagoRepository;

public class PagoServiceImpl implements PagoService {
	
	@Autowired
	private PagoRepository repositorio;

	@Override
	public List<Pago> consultarPagos() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Optional<Pago> consultarPago(Long codigoPago) {
		// TODO Auto-generated method stub
		return repositorio.findById(codigoPago);
	}

	@Override
	public Pago crearPago(Pago pago) {
		// TODO Auto-generated method stub
		return repositorio.save(pago);
	}

	@Override
	public void eliminarPago(Long codigoPago) {
		// TODO Auto-generated method stub
		repositorio.deleteById(codigoPago);
	}

}
