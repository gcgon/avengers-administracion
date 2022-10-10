package com.proyecto.aplicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.aplicacion.model.DetalleFactura;



@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long>{

}