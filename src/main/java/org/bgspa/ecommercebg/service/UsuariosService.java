package org.bgspa.ecommercebg.service;

import java.util.List;

import org.bgspa.ecommercebg.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
	private final UsuariosRepository usuariosRepository;
	
	@Autowired 
	public UsuariosService(UsuariosRepository usuariosRepository) {
		super();
		this.usuariosRepository = usuariosRepository;
	}
	
	//get lista de usuario
	public List<Usuarios> getUsuarios(){
		return usuariosRepository.findAll();
	}
	
	//getUsuario unico
	public Usuarios getUsuario(Long id) {
		return usuariosRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("El usuario con id" + id +" no existe.")
				);
	}
}// class UsuariosService
