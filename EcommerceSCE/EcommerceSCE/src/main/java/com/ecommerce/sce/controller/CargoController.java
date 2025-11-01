package com.ecommerce.sce.controller;

import java.util.Optional;

import org.slf4j.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.sce.model.Cargo;
import com.ecommerce.sce.service.CargoService;

@Controller
@RequestMapping("/cargo")

public class CargoController {

	private final Logger LOGGER = LoggerFactory.getLogger(CargoController.class);

    @Autowired
    private CargoService cargoService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("cargos", cargoService.findAll());
        return "cargo/show";
    }

    @GetMapping("/create")
    public String create() {
        return "cargo/create";
    }

    @PostMapping("/save")
    public String save(Cargo cargo) {
        LOGGER.info("Cargo a guardar: {}", cargo);
        cargoService.save(cargo);
        return "redirect:/cargo";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Cargo> optionalCargo = cargoService.get(id);
        if (optionalCargo.isPresent()) {
            model.addAttribute("cargo", optionalCargo.get());
            LOGGER.info("Cargo buscado: {}", optionalCargo.get());
            return "cargo/edit";
        } else {
            LOGGER.warn("Cargo con ID {} no encontrado", id);
            return "redirect:/cargo";
        }
    }

    @PostMapping("/update")
    public String update(Cargo cargo) {
        cargoService.update(cargo);
        return "redirect:/cargo";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        cargoService.delete(id);
        return "redirect:/cargo";
    }
	
	
}
