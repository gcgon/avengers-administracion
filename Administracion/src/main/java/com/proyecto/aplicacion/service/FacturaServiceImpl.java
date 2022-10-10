package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.aplicacion.model.Factura;
import com.example.aplicacion.repository.FacturaRepository;


@Service
public class FacturaServiceImpl implements FacturaService {
	@Autowired
	private FacturaRepository repositorio;
	
	@Override
	@Transactional
	public List<Factura> consultaFacturas() {
		return repositorio.findAll();
	}

	@Override
	public Optional<com.proyecto.aplicacion.model.Factura> consultaUnaFactura(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Factura crearFactura(Factura factura) {
		// TODO Auto-generated method stub
		return repositorio.save(factura);
	}

	@Override
	public Factura actualizaFactura(Factura factura) {
		// TODO Auto-generated method stub
		return repositorio.save(factura);
	}

	@Override
	public Factura crearFactura(com.proyecto.aplicacion.model.Factura factura) {
		// TODO Auto-generated method stub
		return null;
	}

}
