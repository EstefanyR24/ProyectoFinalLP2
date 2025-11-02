package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sce.model.Proveedor;
import com.ecommerce.sce.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public Proveedor save(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return  proveedorRepository.save(proveedor);
	}

	@Override
	public Optional<Proveedor> get(Integer id) {
		// TODO Auto-generated method stub
		return proveedorRepository.findById(id);
	}

	 @Override
	    public void update(Proveedor proveedor) {
	        // Busca primero si existe
	        Optional<Proveedor> optional = proveedorRepository.findById(proveedor.getId_Proveedor());
	        if(optional.isPresent()) {
	            Proveedor p = optional.get();
	            p.setNombre_Proveedor(proveedor.getNombre_Proveedor());
	            p.setRuc_Proveedor(proveedor.getRuc_Proveedor());
	            proveedorRepository.save(p);
	        }
	    }
	
	@Override
	
	public void delete(Integer id) {
		proveedorRepository.deleteById(id);
	}
	
	@Override
	public List<Proveedor> findAll() {
		// TODO Auto-generated method stub
		return proveedorRepository.findAll();
	}

}
