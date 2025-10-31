package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cargo")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Cargo;
	private String nombre_Cargo;
	
	public Cargo() {
		super();
	}
	public Cargo(Integer id_Cargo, String nombre_Cargo) {
		super();
		this.id_Cargo = id_Cargo;
		this.nombre_Cargo = nombre_Cargo;
	}
	public Integer getId_Cargo() {
		return id_Cargo;
	}
	public void setId_Cargo(Integer id_Cargo) {
		this.id_Cargo = id_Cargo;
	}
	public String getNombre_Cargo() {
		return nombre_Cargo;
	}
	public void setNombre_Cargo(String nombre_Cargo) {
		this.nombre_Cargo = nombre_Cargo;
	}
	@Override
	public String toString() {
		return "Cargo [id_Cargo=" + id_Cargo + ", nombre_Cargo=" + nombre_Cargo + "]";
	}
	
	
	
}
