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
	// delete usuarios
	public Usuarios deleteUsuarios (Long id) {
		Usuarios tmpUser = null; 
		if (usuariosRepository.existsById(id)) {
			tmpUser = usuariosRepository.findById(id).get();
			usuariosRepository.deleteById(id);
		}
		return tmpUser;	
	}
	
	// add usuario
	public Usuarios addUsuarios(Usuarios usuarios) {
		return usuariosRepository.save(usuarios);
	}
	
	// update usuario
	public Usuarios updateUsuarios(Long id, String nombre, String apellido, String telefono, String email, String contrasena) {
		Usuarios tmpUser = null;
		if (usuariosRepository.existsById(id)) {
			tmpUser = usuariosRepository.findById(id).get();
			if (nombre != null) tmpUser.setNombre(nombre);
			if (apellido != null) tmpUser.setApellido(apellido);
			if (telefono != null) tmpUser.setTelefono(telefono);
			if (email != null) tmpUser.setEmail(email);
			if (contrasena != null) tmpUser.setContrasena(contrasena);
			usuariosRepository.save(tmpUser);
		} else {
			System.out.println("Update | El usuario con el id " + " no existe");
		}
		return tmpUser;
	}
}// class UsuariosService
