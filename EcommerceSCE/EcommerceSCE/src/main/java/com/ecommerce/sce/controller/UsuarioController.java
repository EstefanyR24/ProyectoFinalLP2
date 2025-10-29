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
		model.addAttribute("usuario",usuarioService.findAll());
		return "usuario/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "usuario/create";
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		LOGGER.info("Este es el objeto usuario {}",usuario);
		Usuario u = new Usuario(1,"","","");
		usuario.setUsuario(u);
		usuarioService.save(usuario);
		return "redirect:/usuario";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Usuario producto= new Usuario();
		Optional<Usuario> optionalUsuario=usuarioService.get(id);
		producto= optionalUsuario.get();
		LOGGER.info("Usuario buscado: {}",usuario);
		model.addAttribute("usuario", usuario);
		
		return "usuario/edit";
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
