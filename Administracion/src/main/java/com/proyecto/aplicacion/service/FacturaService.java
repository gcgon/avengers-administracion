package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.aplicacion.model.Factura;


public interface FacturaService {
	public List<Factura> consultarFacturas();
	public Optional<Factura>consultaUnaFactura(Long id);
	public Factura crearFactura(Factura factura);
	public void eliminarFactura(Long id);
}
