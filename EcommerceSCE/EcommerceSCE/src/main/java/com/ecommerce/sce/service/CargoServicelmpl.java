package com.ecommerce.sce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sce.model.Cargo;
import com.ecommerce.sce.repository.CargoRepository;

@Service
public class CargoServicelmpl implements CargoService {

	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Override
	public Cargo save(Cargo cargo) {
		// TODO Auto-generated method stub
		return cargoRepository.save(cargo);
	}

	@Override
	public Optional<Cargo> get(Integer id) {
		// TODO Auto-generated method stub
		return cargoRepository.findById(id);
	}

	@Override
	public void update(Cargo cargo) {
		// TODO Auto-generated method stub
		cargoRepository.save(cargo);
	}

	@Override
	public List<Cargo> findAll() {
		// TODO Auto-generated method stub
		return cargoRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		cargoRepository.deleteById(id);
	}
	


}
