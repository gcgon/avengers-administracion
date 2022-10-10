package com.example.apartamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apartamento.model.apartamento;

@Repository
public interface ApartamentoRepository extends JpaRepository<apartamento, Long> {

}
