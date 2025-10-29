package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.sce.model.Usuario;

public interface UsuarioService {

	public Usuario save(Usuario usuario);
	public Optional<Usuario> get(Integer id);
	public void update( Usuario usuario);
	public void delete(Integer id);
	public List<Usuario> findAll();
	
}
