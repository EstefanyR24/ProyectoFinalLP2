package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sce.model.Cotizacion;
import com.ecommerce.sce.repository.CotizacionRepository;

@Service
public class CotizacionServicelmpl implements CotizacionService{

	@Autowired
	
	private CotizacionRepository cotizacionRepository;
	
	@Override
	public Cotizacion save(Cotizacion cotizacion) {
		// TODO Auto-generated method stub
		return cotizacionRepository.save(cotizacion);
	}

	@Override
	public Optional<Cotizacion> get(Integer id) {
		// TODO Auto-generated method stub
		return cotizacionRepository.findById(id);
	}

	@Override
	public void update(Cotizacion cotizacion) {
		cotizacionRepository.save(cotizacion);
		
	}

	@Override
	public List<Cotizacion> findAll() {
		// TODO Auto-generated method stub
		return  cotizacionRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		cotizacionRepository.deleteById(id);
	}

}
