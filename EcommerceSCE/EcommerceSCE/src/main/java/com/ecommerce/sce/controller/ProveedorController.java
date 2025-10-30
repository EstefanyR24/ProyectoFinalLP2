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
import com.ecommerce.sce.service.ProveedorService;
import com.ecommerce.sce.model.Proveedor;
import com.ecommerce.sce.controller.ProveedorController;


@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProveedorController.class);
	
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("proveedor" , proveedorService.findAll());
		return "proveedor/show";
		
		
	}
		@GetMapping("/create")
		public String create() {
			return "proveedor/create";
		}
		
		
		@PostMapping("/save")
		public String save(Proveedor proveedor) {
			LOGGER.info("Este es el objeto:", proveedor);
			proveedorService.save(proveedor);
			return "redirect:/proveedor";
		}
		
		
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable Integer id,Model model){
			Proveedor proveedor = new Proveedor();
			Optional<Proveedor> optionalProveedor= proveedorService.get(id);
			proveedor= optionalProveedor.get();
			model.addAttribute("Proveedor buscado:{}", proveedor);
			return "proveedor/edit";
	
	}
		
		
		@PostMapping("/update")
		public String update(Proveedor proveedor) {
			proveedorService.update(proveedor);
			return "redirect:/proveedor";
			
		
		}
		
	
	
}
