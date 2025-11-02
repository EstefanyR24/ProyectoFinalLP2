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
        Optional<Cargo> existingCargo = cargoRepository.findById(cargo.getId_Cargo());
        if(existingCargo.isPresent()) {
            Cargo c = existingCargo.get();
            c.setNombre_Cargo(cargo.getNombre_Cargo());
            cargoRepository.save(c);
        } else {
            throw new RuntimeException("Cargo no encontrado con id: " + cargo.getId_Cargo());
        }
    }


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		cargoRepository.deleteById(id);
	}
	


	@Override
	public List<Cargo> findAll() {
		// TODO Auto-generated method stub
		return cargoRepository.findAll();
	}

}
