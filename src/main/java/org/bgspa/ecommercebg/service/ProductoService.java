package org.bgspa.ecommercebg.service;

import java.util.List;

import org.bgspa.ecommercebg.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductoService {
	
	private final ProductoRepository productoRepository;
	
	@Autowired 
	public ProductoService(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}//constructor
	
	public List<Producto> getProductos(){
		return productoRepository.findAll();
	}
	
	public Producto getProducto(Long id){
		return productoRepository.findById(id).orElseThrow( 
				()->new IllegalArgumentException("El producto con id" +id +"no existe.")
				);
	}//getProducto
	
	
	

}// class productoService
