package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sce.model.Pedido;
import com.ecommerce.sce.repository.PedidoRepository;

@Service
public class PedidoServicelmpl implements PedidoService{

	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@Override
	public Pedido save(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedidoRepository.save(pedido);
	}

	@Override
	public Optional<Pedido> get(Integer id) {
		// TODO Auto-generated method stub
		return pedidoRepository.findById(id);
	}

	@Override
	public void update(Pedido pedido) {
		pedidoRepository.save(pedido);
		
	}

	@Override
	
	public void delete(Integer id) {
		pedidoRepository.deleteById(id);
	}
	
	
	
	
	@Override
	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return pedidoRepository.findAll();
	}

}
