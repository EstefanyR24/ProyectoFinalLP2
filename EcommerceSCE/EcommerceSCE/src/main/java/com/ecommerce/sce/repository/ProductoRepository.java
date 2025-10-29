package com.ecommerce.sce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.sce.model.Productos;

public interface ProductoRepository extends JpaRepository<Productos, Integer> {

}

