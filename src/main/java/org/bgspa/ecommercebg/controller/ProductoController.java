package org.bgspa.ecommercebg.controller;

import java.util.List;

import org.bgspa.ecommercebg.model.Producto;
import org.bgspa.ecommercebg.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/productos/")
public class ProductoController {
	

		private final ProductoService productoService ;
		
		@Autowired 
		public ProductoController(ProductoService productoService) {
			super();
			this.productoService = productoService;
		}
		
		@GetMapping
		public List<Producto> getAllproductos(){
			return productoService.getProductos();
		}//getAllpro
		
		@GetMapping (path="{prodId}") // http
		public Producto getProducto(@PathVariable("prodId")Long id){
			return productoService.getProducto(id);
		}//getAllpro
		
		
		
		
		

}
