package com.ecommerce.sce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.sce.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	

}
