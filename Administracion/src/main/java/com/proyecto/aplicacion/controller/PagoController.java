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

import com.proyecto.aplicacion.model.Pago;
import com.proyecto.aplicacion.service.PagoService;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

	@Autowired
	private PagoService pagoService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Pago pago){
		return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.crearPago(pago));
	}
	
	@GetMapping
	public List<Pago> readAll(){
		return pagoService.consultarPagos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Pago> pago = pagoService.consultarPagoPorId(id);
		if(!pago.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pago);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Pago pagoDetalle, @PathVariable Long id){
		Optional<Pago> pago = pagoService.consultarPagoPorId(id);
		if(!pago.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(pagoDetalle, pago.get());
		pago.get().setCodigoPago(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.crearPago(pago.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Pago> pago = pagoService.consultarPagoPorId(id);
		if(!pago.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		pagoService.eliminarPago(id);
		return ResponseEntity.ok().build();
	}

	
	
	
	
}
