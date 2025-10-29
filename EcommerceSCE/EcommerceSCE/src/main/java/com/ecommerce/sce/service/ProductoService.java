package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.sce.model.Productos;

public interface ProductoService {

	public Productos save(Productos usuario);
	public Optional<Productos> get(Integer id);
	public void update(Productos producto);
	public void delete(Integer id);

	public List<Productos> findAll();
	
	
	
}
