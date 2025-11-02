package com.ecommerce.sce.controller;

import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.sce.model.Cotizacion;
import com.ecommerce.sce.service.CotizacionService;

@Controller
@RequestMapping("/cotizacion")
public class CotizacionController {

	private final Logger LOGGER = LoggerFactory.getLogger(CotizacionController.class);

    @Autowired
    private CotizacionService cotizacionService;

    @GetMapping
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
        LOGGER.info("Cotización a guardar: {}", cotizacion);
        cotizacionService.save(cotizacion);
        return "redirect:/cotizacion";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Cotizacion> optional = cotizacionService.get(id);
        if (optional.isPresent()) {
            model.addAttribute("cotizacion", optional.get());
            LOGGER.info("Cotización buscada: {}", optional.get());
            return "cotizacion/edit";
        } else {
            LOGGER.warn("Cotización con ID {} no encontrada", id);
            return "redirect:/cotizacion";
        }
    }

    @PostMapping("/update")
    public String update(Cotizacion cotizacion) {
        cotizacionService.update(cotizacion);
        return "redirect:/cotizacion";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            cotizacionService.delete(id);
            return "redirect:/cotizacion";
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("No se puede eliminar la cotización con ID {} porque tiene pedidos asociados", id);
            model.addAttribute("error", "No se puede eliminar la cotización porque tiene pedidos asociados");
            model.addAttribute("cotizaciones", cotizacionService.findAll());
            return "cotizacion/show";
        }
    }
	
	
}
