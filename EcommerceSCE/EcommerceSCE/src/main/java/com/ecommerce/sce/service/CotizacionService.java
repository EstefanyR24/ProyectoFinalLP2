package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.sce.model.Cotizacion;

public interface CotizacionService {

	
	public Cotizacion save(Cotizacion cotizacion);
	public Optional<Cotizacion> get(Integer id);
	public void update(Cotizacion cotizacion);
	public void delete(Integer id);
	public List<Cotizacion> findAll();
}
