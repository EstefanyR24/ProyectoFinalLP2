package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.sce.model.Cargo;

public interface CargoService {

	public Cargo save(Cargo cargo);
	public Optional<Cargo> get(Integer id);
	public void update(Cargo cargo);
	public void delete(Integer id);
public List<Cargo> findAll();
	
	
	
}
