package com.proyecto.aplicacion.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.aplicacion.model.Usuario;
import com.proyecto.aplicacion.service.UsuarioService;
import com.proyecto.aplicacion.util.JWTUtil;

@RestController
@RequestMapping("/api/authorization")
public class AuthorizationController {
	
	@Autowired
    private UsuarioService UsuarioService;

    @Autowired
    private JWTUtil jwtUtil;
    
    @PostMapping
	public ResponseEntity<?> createtoken(@RequestBody Usuario usuarioDetalle){
		List<Usuario> usuario = UsuarioService.consultarAdminUser(usuarioDetalle.getNro_documento_usuario(), usuarioDetalle.getClave());
		if(usuario!=null && usuario.size()>0) {
			String tokenJwt = jwtUtil.getJWTToken(usuario.get(0).getNro_documento_usuario()+"");
			tokenJwt=tokenJwt+"("+usuario;
            return ResponseEntity.ok(new JSONObject().put("access", tokenJwt.replace("Bearer ", "")).toString());
		} 
		return ResponseEntity.notFound().build();
	}
}
