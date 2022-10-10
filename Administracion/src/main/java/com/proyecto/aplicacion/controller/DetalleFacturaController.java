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

import com.proyecto.aplicacion.model.DetalleFactura;
import com.proyecto.aplicacion.service.DetalleFacturaService;


@RestController
@RequestMapping("api/detalleFactura")
public class DetalleFacturaController {
	
	@Autowired
	private DetalleFacturaService detalleFacturaService;
	
	@PostMapping
	public ResponseEntity<?>crearProducto(@RequestBody DetalleFactura detalleFactura){
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleFacturaService.crearDetalleFactura(detalleFactura));
	}
	
	@GetMapping
	public List<DetalleFactura> consultardetallesFactura(){
		return detalleFacturaService.consultarDetallesFactura();			
	}
	
	@GetMapping("/{nroDetalleFactura}")
	public ResponseEntity<?> consultardetalleFactura(@PathVariable Long nroDetalleFactura){
		Optional<DetalleFactura> detalleFactura = detalleFacturaService.consultarDetalleFactura(nroDetalleFactura);
		if(!detalleFactura.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(detalleFactura);
	}
	
	@PutMapping("/{nroDetalleFactura}")
	public ResponseEntity<?> actualizardetalleFactura(@RequestBody DetalleFactura conceptoDetalleF, @PathVariable Long nroDetalleFactura){
		Optional<DetalleFactura> detalleFactura = detalleFacturaService.consultarDetalleFactura(nroDetalleFactura);
		if(!detalleFactura.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(conceptoDetalleF, detalleFactura.get());
						
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleFacturaService.crearDetalleFactura(detalleFactura.get()));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarDetalleFactura(@PathVariable Long nroDetalleFactura){
		Optional<DetalleFactura> detalleFactura = detalleFacturaService.consultarDetalleFactura(nroDetalleFactura);
		if(!detalleFactura.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		detalleFacturaService.eliminarDetalleFactura(nroDetalleFactura);
		return ResponseEntity.ok().build();
	}
}
