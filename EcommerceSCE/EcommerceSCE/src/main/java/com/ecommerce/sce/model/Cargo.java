package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCargo;
	
	private String nombreCargo;

	public Cargo(int idCargo, String nombreCargo) {
		super();
		this.idCargo = idCargo;
		this.nombreCargo = nombreCargo;
	}

	public Cargo() {
		super();
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNombreCargo() {
		return nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	@Override
	public String toString() {
		return "Cargo [idCargo=" + idCargo + ", nombreCargo=" + nombreCargo + "]";
	}

	
	
	
}
