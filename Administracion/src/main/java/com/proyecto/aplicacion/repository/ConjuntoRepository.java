package com.proyecto.aplicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.aplicacion.model.Conjunto;


@Repository
public interface ConjuntoRepository extends JpaRepository<Conjunto, Long>{

}
