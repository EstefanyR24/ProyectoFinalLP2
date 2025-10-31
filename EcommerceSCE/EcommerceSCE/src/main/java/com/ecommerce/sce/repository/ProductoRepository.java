package com.ecommerce.sce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.sce.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}

