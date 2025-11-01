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

import com.ecommerce.sce.service.UsuarioService;
import com.ecommerce.sce.model.Cargo;
import com.ecommerce.sce.model.Usuario;
import com.ecommerce.sce.controller.UsuarioController;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "usuario/show";
    }

    @GetMapping("/create")
    public String create() {
        return "usuario/create";
    }

    @PostMapping("/save")
    public String save(Usuario usuario) {
        LOGGER.info("Usuario a guardar: {}", usuario);
        usuarioService.save(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Usuario> optional = usuarioService.get(id);
        if (optional.isPresent()) {
            model.addAttribute("usuario", optional.get());
            LOGGER.info("Usuario buscado: {}", optional.get());
            return "usuario/edit";
        }
        return "redirect:/usuario";
    }

    @PostMapping("/update")
    public String update(Usuario usuario) {
        usuarioService.update(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        usuarioService.delete(id);
        return "redirect:/usuario";
    }

}
