package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.aplicacion.model.Factura;
import com.proyecto.aplicacion.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private FacturaRepository repositorio;

	@Override
	@Transactional
	public List<Factura> consultarFacturas() {
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public Optional<Factura> consultaUnaFactura(Long id) {
		return repositorio.findById(id);
	}

	@Override
	@Transactional
	public Factura crearFactura(Factura factura) {
		return repositorio.save(factura);
	}

	@Override
	@Transactional
	public void eliminarFactura(Long id) {
		repositorio.deleteById(id);
	}

	

}
