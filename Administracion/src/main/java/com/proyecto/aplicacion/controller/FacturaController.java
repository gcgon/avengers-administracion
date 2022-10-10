package com.proyecto.aplicacion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.aplicacion.model.Factura;
import com.proyecto.aplicacion.service.FacturaService;

@RestController
@RequestMapping ("/factura")
public class FacturaController {

	@Autowired
	private FacturaService facturaservice;
	
	@GetMapping 
	public List<com.example.aplicacion.model.Factura> readAll(){
		return facturaservice.consultaFacturas();
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Factura> factura = facturaservice.consultaUnaFactura(id);
		if(!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(factura);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Factura factura){
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaservice.crearFactura(factura));
	}
	
	
	
}
