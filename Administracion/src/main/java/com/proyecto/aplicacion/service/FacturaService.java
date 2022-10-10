package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import com.example.aplicacion.model.Factura;


public interface FacturaService {

	public List<Factura> consultaFacturas();
	public Optional<com.proyecto.aplicacion.model.Factura> consultaUnaFactura(Long id);
	public Factura crearFactura(com.proyecto.aplicacion.model.Factura factura);
	public Factura actualizaFactura(Factura factura);
	Factura crearFactura(Factura factura);
	
}
