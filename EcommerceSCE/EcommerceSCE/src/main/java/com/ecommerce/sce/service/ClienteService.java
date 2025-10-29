package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.sce.model.Cliente;

public interface ClienteService {

	
	public Cliente save(Cliente cliente);
	public Optional<Cliente> get(Integer id);
	public void update(Cliente cliente);
	public void delete(Integer id);
	public List<Cliente> findAll();
	
	
	
	
	
}
