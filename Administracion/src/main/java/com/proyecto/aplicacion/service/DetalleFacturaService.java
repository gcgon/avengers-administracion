package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.aplicacion.model.DetalleFactura;

public interface DetalleFacturaService {
	public List<DetalleFactura> consultarDetallesFactura();
	public Optional<DetalleFactura>consultarDetalleFactura(Long nroDetalleFactura);
	public DetalleFactura crearDetalleFactura(DetalleFactura detallefactura);
	public void eliminarDetalleFactura(Long nroDetalleFactura);
}
