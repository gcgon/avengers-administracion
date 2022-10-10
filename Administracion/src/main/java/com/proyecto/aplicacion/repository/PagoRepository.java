package com.proyecto.aplicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.proyecto.aplicacion.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long>{

}
