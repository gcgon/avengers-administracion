package com.proyecto.aplicacion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.aplicacion.model.Apartamento;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long>{

}
