package com.proyecto.aplicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.aplicacion.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>{

}