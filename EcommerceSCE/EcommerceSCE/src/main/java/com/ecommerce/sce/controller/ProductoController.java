package com.ecommerce.sce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.sce.service.ProductoService;
import com.ecommerce.sce.model.Proveedor;
import com.ecommerce.sce.model.Productos;
import com.ecommerce.sce.controller.ProductoController;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("producto",productoService.findAll());
		return "producto/show";
	}
	
	
	@GetMapping("/create")
	public String create() {
		return "producto/create";
	}
	
	
	@PostMapping("/save")
	public String save(Productos productos) {
		LOGGER.info("Este es el objeto producto {}",productos);
		Proveedor p = new Proveedor(1,"", "");
		productos.setProveedor(p);
		productoService.save(productos);
		return "redirect:/producto";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Productos producto= new Productos();
		Optional<Productos> optionalProducto=productoService.get(id);
		producto= optionalProducto.get();
		LOGGER.info("Producto buscado: {}",producto);
		model.addAttribute("producto", producto);
		
		return "producto/edit";
	}
	
	
	
	@PostMapping("/update")
	public String update(Productos producto) {
		productoService.update(producto);		
		return "redirect:/producto";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productoService.delete(id);
		return "redirect:/producto";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
