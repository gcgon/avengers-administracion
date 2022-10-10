package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.aplicacion.model.DetalleFactura;
import com.proyecto.aplicacion.repository.DetalleFacturaRepository;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {
	
	@Autowired
	private DetalleFacturaRepository repositorio;
	
	
	@Override
	@Transactional
	public List<DetalleFactura> consultarDetallesFactura() {
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public Optional<DetalleFactura> consultarDetalleFactura(Long nroDetalleFactura) {
		return repositorio.findById(nroDetalleFactura);
	}

	@Override
	@Transactional
	public DetalleFactura crearDetalleFactura(DetalleFactura detalleFactura) {
		return repositorio.save(detalleFactura);
	}

	@Override
	@Transactional
	public void eliminarDetalleFactura(Long nroDetalleFactura) {
		repositorio.deleteById(nroDetalleFactura);
	}

}