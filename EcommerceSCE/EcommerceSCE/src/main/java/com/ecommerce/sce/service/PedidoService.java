package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.sce.model.Pedido;

public interface PedidoService {

	public Pedido save(Pedido pedido);
	public Optional<Pedido> get(Integer id);
	public void update(Pedido pedido);
	public void delete(Integer id);
public List<Pedido> findAll();
	
	
	
	
	
	
}
