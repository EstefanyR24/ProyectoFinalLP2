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
import com.ecommerce.sce.model.Producto;
import com.ecommerce.sce.controller.ProductoController;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "producto/show";
    }

    @GetMapping("/create")
    public String create() {
        return "producto/create";
    }

    @PostMapping("/save")
    public String save(Producto producto) {
        LOGGER.info("Producto a guardar: {}", producto);
        // Si deseas asociar manualmente un proveedor:
        // Proveedor p = new Proveedor(); p.setId_Proveedor(1); producto.setProveedor(p);
        productoService.save(producto);
        return "redirect:/producto";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Producto> optional = productoService.get(id);
        if (optional.isPresent()) {
            model.addAttribute("producto", optional.get());
            LOGGER.info("Producto buscado: {}", optional.get());
            return "producto/edit";
        }
        return "redirect:/producto";
    }

    @PostMapping("/update")
    public String update(Producto producto) {
        productoService.update(producto);
        return "redirect:/producto";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productoService.delete(id);
        return "redirect:/producto";
    }
	
}
