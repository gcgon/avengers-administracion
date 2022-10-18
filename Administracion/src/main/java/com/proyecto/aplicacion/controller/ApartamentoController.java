package com.proyecto.aplicacion.controller;

import java.io.Serializable;
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

import com.proyecto.aplicacion.model.Apartamento;
import com.proyecto.aplicacion.service.ApartamentoService;

@RestController
@RequestMapping("/apartamento")
public class ApartamentoController implements Serializable {

	private static final long serialVersionUID = 5129436431561337112L;
	
	@Autowired
	private ApartamentoService apartamentoService;
	
	@PostMapping
	public ResponseEntity<?> crearApartamento(@RequestBody Apartamento apartamento){
		return ResponseEntity.status(HttpStatus.CREATED).body(apartamentoService.crearApartamento(apartamento));
	}
	
	@GetMapping
	public List<Apartamento> consultarApartamentos(){
		return apartamentoService.consultarApartamentos();					
	}
	
	@GetMapping("/{idApartamento}")
	public ResponseEntity<?> consultarApartamento(@PathVariable Long idApartamento){
		Optional<Apartamento> apartamento = apartamentoService.consultarApartamento(idApartamento);
		if(!apartamento.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(apartamento);
	}
	
	@PutMapping("/{idApartamento}")
	public ResponseEntity<?> actualizarApartamento(@RequestBody Apartamento detalleApartamento, @PathVariable Long idApartamento){
		Optional<Apartamento> apartamento = apartamentoService.consultarApartamento(idApartamento);
		if(!apartamento.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(detalleApartamento, apartamento.get());
		apartamento.get().setIdApartamento(idApartamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(apartamentoService.crearApartamento(apartamento.get()));
	}
	
	
	@DeleteMapping("/{idApartamento}")
	public ResponseEntity<?> eliminarApartamento(@PathVariable Long idApartamento){
		Optional<Apartamento> apartamento = apartamentoService.consultarApartamento(idApartamento);
		if(!apartamento.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		apartamentoService.eliminarApartamento(idApartamento);
		return ResponseEntity.ok().build();
	}
}
