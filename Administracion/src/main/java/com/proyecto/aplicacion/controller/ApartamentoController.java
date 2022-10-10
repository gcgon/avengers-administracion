package com.example.apartamento.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.apartamento.model.apartamento;
import com.example.apartamento.services.ApartamentoService;

@RestController
@RequestMapping("/apartamento")
public class ApartamentoController {
	@Autowired
	private ApartamentoService servicio;
	@GetMapping
	public ResponseEntity<?> consultaId_apartamentos(){
		return ResponseEntity.ok(servicio.consultarApartamentos());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> consultaId_partamentos(Long id_apartamento){
		return ResponseEntity.ok(servicio.consultarApartamentos());
	}
	@PostMapping
	public ResponseEntity<?> create(apartamento id_apartamento){
		return ResponseEntity.status(HttpStatus.CREATED).body(ApartamentoService.() ));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizaId_apartamentos(apartamento id_apartamento){
		return ResponseEntity.ok(servicio.guardarApartamentos(id_apartamento));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarId_apartamentos(Long id_apartamento){
		return ResponseEntity.ok("Eliminar Apartamentos");
	}
	
	}



