package org.bgspa.ecommercebg.controller;

import java.util.List;

import org.bgspa.ecommercebg.model.Usuarios;
import org.bgspa.ecommercebg.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//Metodo delete para un usuario
	@DeleteMapping (path="{userId}")
	public Usuarios deleteUsuarios(@PathVariable("userId") Long id) {
		return usuariosService.deleteUsuarios(id);
	}
	
	//Metodo post para un usuario
	@PostMapping
	public Usuarios addUsuarios(@RequestBody Usuarios usuarios) {
		return usuariosService.addUsuarios(usuarios);
	}
	
	//Metodo put para un usuario
	@PutMapping(path="{userId}")
	public Usuarios updateUsuarios(@PathVariable("userId") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellido,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String usuario,
			@RequestParam(required = false) String contrasena) {
		return usuariosService.updateUsuarios(id, nombre, apellido, telefono, usuario, contrasena);
		
	}
	
}
