package com.proyecto.aplicacion.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.aplicacion.model.Pago;


public interface PagoService {
	public List<Pago> consultarPagos();
	public Optional<Pago>consultarPagoPorId(Long codigoPago);
	public Pago crearPago(Pago pago);
	public void eliminarPago(Long codigoPago);
}
