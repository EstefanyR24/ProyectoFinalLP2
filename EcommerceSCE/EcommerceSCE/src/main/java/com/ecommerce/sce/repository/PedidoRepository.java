package com.ecommerce.sce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.sce.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
