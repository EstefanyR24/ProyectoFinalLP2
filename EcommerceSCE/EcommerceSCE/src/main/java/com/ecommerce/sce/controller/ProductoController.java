package com.ecommerce.sce.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.sce.model.Producto;
import com.ecommerce.sce.model.Proveedor;
import com.ecommerce.sce.service.ProductoService;
import com.ecommerce.sce.service.ProveedorService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

   
    @GetMapping("/create")
    public String create(Model model) {
        List<Proveedor> proveedores = proveedorService.findAll();
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("producto", new Producto());
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam("id_Proveedor") Integer idProveedor,
                       @ModelAttribute Producto producto) {

        Proveedor proveedor = proveedorService.get(idProveedor).orElse(null);
        if(proveedor != null){
            producto.setProveedor(proveedor);
        }

        productoService.save(producto);
        return "redirect:/productos";
    }
 // Formulario para editar
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Producto> optional = productoService.get(id);
        if (optional.isPresent()) {
            List<Proveedor> proveedores = proveedorService.findAll();
            model.addAttribute("proveedores", proveedores);
            model.addAttribute("producto", optional.get());
            return "productos/edit";
        }
        return "redirect:/productos";
    }

  
    @PostMapping("/update")
    public String update(@ModelAttribute Producto producto,
                         @RequestParam("id_Proveedor") Integer idProveedor) {
        
        Proveedor proveedor = proveedorService.get(idProveedor).orElse(null);
        if (proveedor != null) {
            producto.setProveedor(proveedor);
        }

        LOGGER.info("Producto a actualizar: {}", producto);
        productoService.update(producto);
        return "redirect:/productos";
    }


  
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productoService.delete(id);
        return "redirect:/productos";
    }
}
