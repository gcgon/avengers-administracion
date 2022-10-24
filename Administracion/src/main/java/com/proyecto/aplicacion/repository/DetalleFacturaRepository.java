package com.proyecto.aplicacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.aplicacion.model.DetalleFactura;



@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long>{
	
	@Query(value = "SELECT detFact.nroDetalleFactura, detFact.factura, detFact.valorFacturaPendiente FROM detalleFactura detFact WHERE detFact.apartamento = :apartamento", nativeQuery = true)
	public List<DetalleFactura> consultarDetalleFacturaP(Long apartamento);
}