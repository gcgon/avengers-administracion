package com.proyecto.aplicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.aplicacion.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {

}
