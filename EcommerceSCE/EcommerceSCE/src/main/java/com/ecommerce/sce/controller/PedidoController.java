package com.ecommerce.sce.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.sce.model.Pedido;
import com.ecommerce.sce.model.Producto;
import com.ecommerce.sce.repository.*;
import com.ecommerce.sce.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private final Logger LOGGER = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CotizacionRepository cotizacionRepository;

    //  LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidoService.findAll());
        return "pedido/show";
    }

    //  CREAR
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("cotizaciones", cotizacionRepository.findAll());
        return "pedido/create";
    }

    //  GUARDAR
    @PostMapping("/save")
    public String save(@ModelAttribute Pedido pedido,
                       @RequestParam("productos") List<Integer> productosIds) {

        List<Producto> productos = productoRepository.findAllById(productosIds);
        pedido.setProductos(productos);

        pedidoService.save(pedido);
        LOGGER.info("Pedido guardado correctamente: {}", pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Pedido> optionalPedido = pedidoService.get(id);
        if (optionalPedido.isPresent()) {
            model.addAttribute("pedido", optionalPedido.get());
            model.addAttribute("productos", productoRepository.findAll());
            model.addAttribute("clientes", clienteRepository.findAll());
            model.addAttribute("usuarios", usuarioRepository.findAll());
            model.addAttribute("cotizaciones", cotizacionRepository.findAll());
            return "pedido/edit"; // ✅ Singular, coincide con tu carpeta real
        }
        return "redirect:/pedidos";
    }

    //  ACTUALIZAR
    @PostMapping("/update")
    public String update(@ModelAttribute Pedido pedido,
                         @RequestParam("productos") List<Integer> productosIds) {

        List<Producto> productos = productoRepository.findAllById(productosIds);
        pedido.setProductos(productos);

        pedidoService.update(pedido);
        LOGGER.info("Pedido actualizado: {}", pedido);
        return "redirect:/pedidos";
    }

    //  ELIMINAR
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        pedidoService.delete(id);
        LOGGER.info("Pedido eliminado ID: {}", id);
        return "redirect:/pedidos";
    }
}
