package org.bgspa.ecommercebg.controller;

import java.util.List;

import org.bgspa.ecommercebg.model.Categorias;
import org.bgspa.ecommercebg.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/categorias/")
public class CategoriasController {
	
	private final CategoriasService categoriasService ;
	
	@Autowired 
	public CategoriasController(CategoriasService categoriasService) {
		super();
		this.categoriasService = categoriasService;
	}
	
	@GetMapping
	public List<Categorias> getAllcategorias(){
		return categoriasService.getCategorias();
	}//getAllpro
	
	@GetMapping (path="{prodId}") // http
	public Categorias getCategorias(@PathVariable("prodId")Long id){
		return categoriasService.getCategoria(id);
	}//getAllpro
		

}
