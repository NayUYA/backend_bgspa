package org.bgspa.ecommercebg.service;

import java.util.List;

import org.bgspa.ecommercebg.model.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService {
	private final DireccionRepository direccionRepository;

	@Autowired
	public DireccionService(DireccionRepository direccionRepository) {
		super();
		this.direccionRepository = direccionRepository;
	}//constructor
	
	public List<Direccion> getDirecciones(){
		return direccionRepository.findAll();
	}
	
	public Direccion getDireccion(Long id){
		return direccionRepository.findById(id).orElseThrow( 
				()->new IllegalArgumentException("La direccion con id" +id +"no existe.")
				);
	}//getProducto
	
}//class DireccionService
