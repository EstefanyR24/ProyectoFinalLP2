package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sce.model.Usuario;
import com.ecommerce.sce.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> get(Integer id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Override
	public void update(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}
	
	@Override
	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return  usuarioRepository.findAll();
	}



}
