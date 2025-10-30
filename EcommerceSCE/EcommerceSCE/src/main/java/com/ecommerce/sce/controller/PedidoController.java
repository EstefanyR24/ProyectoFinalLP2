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

import com.ecommerce.sce.model.Pedido;
import com.ecommerce.sce.service.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	 private final Logger LOGGER = LoggerFactory.getLogger(PedidoController.class);

	    @Autowired
	    private PedidoService pedidoService;
	    
	    @GetMapping("")
	    public String show(Model model) {
	        model.addAttribute("pedidos", pedidoService.findAll());
	        return "pedido/show";
	    }
	    
	    @GetMapping("/create")
	    public String create(Model model) {
	        model.addAttribute("pedido", new Pedido());
	        return "pedido/create";
	    }
	    
	    @PostMapping("/save")
	    public String save(Pedido pedido) {
	        LOGGER.info("Pedido a guardar: {}", pedido);
	        pedidoService.save(pedido);
	        return "redirect:/pedido";
	    }
	    
	    @GetMapping("/edit/{id}")
	    public String edit(@PathVariable Integer id, Model model) {
	        Optional<Pedido> optionalPedido = pedidoService.get(id);
	        if (optionalPedido.isPresent()) {
	            model.addAttribute("pedido", optionalPedido.get());
	            return "pedido/edit";
	        }
	        return "redirect:/pedido";
	    }
	    
	    @PostMapping("/update")
	    public String update(Pedido pedido) {
	        LOGGER.info("Pedido a actualizar: {}", pedido);
	        pedidoService.update(pedido);
	        return "redirect:/pedido";
	    }
	    
	    @GetMapping("/delete/{id}")
	    public String delete(@PathVariable Integer id) {
	        LOGGER.info("Pedido a eliminar ID: {}", id);
	        pedidoService.delete(id);
	        return "redirect:/pedido";
	    }
	
}
