package org.bgspa.ecommercebg.controller;


import java.util.List;

import org.bgspa.ecommercebg.model.Direccion;
import org.bgspa.ecommercebg.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/direccion/")
public class DireccionController {
	private final DireccionService direccionService;

	@Autowired 
	public DireccionController(DireccionService direccionService) {
		super();
		this.direccionService = direccionService;
	}//constructor
	
	@GetMapping
	public List<Direccion> getAlldirecciones(){
		return direccionService.getDirecciones();
	}//getAlldir
	
	@GetMapping (path="{dirId}") // http
	public Direccion getDireccion(@PathVariable("dirId")Long id){
		return direccionService.getDireccion(id);
	}//getAlldir
	
	
}
