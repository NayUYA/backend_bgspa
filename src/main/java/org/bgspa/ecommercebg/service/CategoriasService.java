package org.bgspa.ecommercebg.service;

import java.util.List;

import org.bgspa.ecommercebg.model.Categorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService {
	private final CategoriasRepository categoriasRepository;
	
	//---Constructor------------------------------------------------
	@Autowired 
	public CategoriasService(CategoriasRepository categoriasRepository) {
		super();
		this.categoriasRepository = categoriasRepository;
	}//constructor
	
	//-----Get Categorias y Categoria---------------------------------
	public List<Categorias> getCategorias(){
		return categoriasRepository.findAll();
	}//getCategorias
	
	public Categorias getCategoria(Long id){
		return categoriasRepository.findById(id).orElseThrow( 
				()->new IllegalArgumentException("El producto con id" +id +"no existe.")
				);
	}//getCategoria
	
}//class CategoriaService
