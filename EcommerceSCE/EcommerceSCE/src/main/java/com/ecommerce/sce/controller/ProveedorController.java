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
@RequestMapping("/proveedores")
public class ProveedorController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProveedorController.class);

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("proveedores", proveedorService.findAll());
        return "proveedor/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("proveedor", new Proveedor()); // Objeto vacío para el formulario
        return "proveedor/create";
    }
    

    @PostMapping("/save")
    public String save(Proveedor proveedor) {
        LOGGER.info("Proveedor a guardar: {}", proveedor);
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Proveedor> optional = proveedorService.get(id);
        if (optional.isPresent()) {
            model.addAttribute("proveedor", optional.get());
            LOGGER.info("Proveedor buscado: {}", optional.get());
            return "proveedor/edit";
        }
        return "redirect:/proveedores";
    }

    @PostMapping("/update")
    public String update(Proveedor proveedor) {
        proveedorService.update(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        proveedorService.delete(id);
        return "redirect:/proveedores";
    }	
	
}
