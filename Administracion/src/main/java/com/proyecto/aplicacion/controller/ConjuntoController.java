package com.proyecto.aplicacion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.aplicacion.model.Conjunto;
import com.proyecto.aplicacion.service.ConjuntoService;


@RestController
@RequestMapping("api/Conjunto")
public class ConjuntoController {
	@Autowired
	private ConjuntoService conjuntoService;
	
	@PostMapping
	public ResponseEntity<?> crearConjunto(@RequestBody Conjunto conjunto){
		return ResponseEntity.status(HttpStatus.CREATED).body(conjuntoService.crearConjunto(conjunto));
	}
	
	@GetMapping
	public List<Conjunto> consultarconjuntos(){
		return conjuntoService.consultarConjuntos();					
	}
	
	@GetMapping("/{nitConjunto}")
	public ResponseEntity<?> consultarConjunto(@PathVariable Long nitConjunto){
		Optional<Conjunto> conjunto = conjuntoService.consultarConjunto(nitConjunto);
		if(!conjunto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(conjunto);
	}
	
	@PutMapping("/{nitConjunto}")
	public ResponseEntity<?> actualizarConjunto(@RequestBody Conjunto detalleConjunto, @PathVariable Long nitConjunto){
		Optional<Conjunto> conjunto = conjuntoService.consultarConjunto(nitConjunto);
		if(!conjunto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(detalleConjunto, conjunto.get());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(conjuntoService.crearConjunto(conjunto.get()));
	}
	
	
	@DeleteMapping("/{nitConjunto}")
	public ResponseEntity<?> eliminarConjunto(@PathVariable Long nitConjunto){
		Optional<Conjunto> conjunto = conjuntoService.consultarConjunto(nitConjunto);
		if(!conjunto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		conjuntoService.eliminarConjunto(nitConjunto);
		return ResponseEntity.ok().build();
	}
}
