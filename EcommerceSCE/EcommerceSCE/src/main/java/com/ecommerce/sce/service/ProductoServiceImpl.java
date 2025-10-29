package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sce.model.Productos;
import com.ecommerce.sce.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Productos save(Productos producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Productos> get(Integer id) {
		return productoRepository.findById(id);
	}

	@Override
	public void update(Productos producto) {
		productoRepository.save(producto);		
	}

	@Override
	public void delete(Integer id) {
		productoRepository.deleteById(id);		
	}

	@Override
	public List<Productos> findAll() {
		return productoRepository.findAll();
	}

}
