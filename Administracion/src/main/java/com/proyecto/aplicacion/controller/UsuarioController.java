package com.proyecto.aplicacion.controller;

import java.io.Serializable;
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

import com.proyecto.aplicacion.model.Usuario;
import com.proyecto.aplicacion.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController  implements Serializable {

	private static final long serialVersionUID = 4575976916513745015L;
	
	@Autowired
	private UsuarioService servicio;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable Long id){
		Optional<Usuario> usuario = servicio.consultarUsuario(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(servicio.consultarUsuario(id));
	}
	
		
	@PostMapping
	public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearUsuario(usuario));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
		Optional<Usuario> persona = servicio.consultarUsuario(id);
		if(!persona.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(usuario, persona.get());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearUsuario(usuario));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Long id){
		Optional<Usuario> persona = servicio.consultarUsuario(id);
		if(!persona.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		servicio.eliminarUsuario(id);
		return ResponseEntity.ok().build();
	}
}
