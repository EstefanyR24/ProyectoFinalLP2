package com.ecommerce.sce.controller;

import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.sce.model.Cotizacion;
import com.ecommerce.sce.service.CotizacionService;

public class CotizacionController {

	private final Logger LOGGER = LoggerFactory.getLogger(CotizacionController.class);
	@Autowired
	private CotizacionService cotizacionService;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("cotizaciones", cotizacionService.findAll());
		return "cotizacion/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "cotizacion/create";
	}
	
	@PostMapping("/save")
	public String save(Cotizacion cotizacion) {
		LOGGER.info("esta es una cotizacion {}", cotizacion);
		cotizacionService.save(cotizacion);
		return "redirect:/cotizacion";
	}
	
	
	@GetMapping("/edit/{id}")
public String edit(@PathVariable Integer id ,Model model) {
		Cotizacion cotizacion = new Cotizacion();
		Optional<Cotizacion> optionalCotizacion=cotizacionService.get(id);
		cotizacion=optionalCotizacion.get();
		LOGGER.info("Cotizacion buscada:{}",cotizacion);
		
		return "cotizacion/edit";
	
	}
	
	
	
	
	
		@PostMapping("/update")
	public String update(Cotizacion cotizacion) {
			cotizacionService.update(cotizacion);		
		return "redirect:/cotizacion";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		cotizacionService.delete(id);
		return "redirect:/cotizacion";
	}
	
	
	
	
	
	
}
