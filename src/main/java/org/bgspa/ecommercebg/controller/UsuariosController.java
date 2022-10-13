package org.bgspa.ecommercebg.controller;

import java.util.List;

import org.bgspa.ecommercebg.model.Usuarios;
import org.bgspa.ecommercebg.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/usuarios/")
public class UsuariosController {
	private final UsuariosService usuariosService;
	
	@Autowired
	public UsuariosController(UsuariosService usuariosService) {
		super();
		this.usuariosService = usuariosService;
	}
	
	//Metodo get para la lista de usuarios
	@GetMapping
	public List<Usuarios> getAllusuarios(){
		return usuariosService.getUsuarios();
	}
	
	//Metodo get para un usuario
	@GetMapping (path="{userId}")
	public Usuarios getUsuario(@PathVariable("userId")Long id) {
		return usuariosService.getUsuario(id);
	}
	
	
	

}
