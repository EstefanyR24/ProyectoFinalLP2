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

import com.ecommerce.sce.model.Cliente;
import com.ecommerce.sce.service.ClienteService;



@Controller
@RequestMapping("/cliente")
public class ClienteController {

	private final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "cliente/show";
    }

    @GetMapping("/create")
    public String create() {
        return "cliente/create";
    }

    @PostMapping("/save")
    public String save(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Cliente> optionalCliente = clienteService.get(id);
        if (optionalCliente.isPresent()) {
            model.addAttribute("cliente", optionalCliente.get());
            LOGGER.info("Cliente buscado: {}", optionalCliente.get());
            return "cliente/edit";
        } else {
            LOGGER.warn("Cliente con ID {} no encontrado", id);
            return "redirect:/cliente";
        }
    }

    @PostMapping("/update")
    public String update(Cliente cliente) {
        clienteService.update(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return "redirect:/cliente";
    }
	
	
}
