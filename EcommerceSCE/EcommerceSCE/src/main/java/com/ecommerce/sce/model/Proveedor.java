package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Proveedor;
	
	private String nombre_Proveedor;
	
	private String ruc_Proveedor;

	public Proveedor() {
		super();
	}

	public Proveedor(Integer id_Proveedor, String nombre_Proveedor, String ruc_Proveedor) {
		super();
		this.id_Proveedor = id_Proveedor;
		this.nombre_Proveedor = nombre_Proveedor;
		this.ruc_Proveedor = ruc_Proveedor;
	}

	public Integer getId_Proveedor() {
		return id_Proveedor;
	}

	public void setId_Proveedor(Integer id_Proveedor) {
		this.id_Proveedor = id_Proveedor;
	}

	public String getNombre_Proveedor() {
		return nombre_Proveedor;
	}

	public void setNombre_Proveedor(String nombre_Proveedor) {
		this.nombre_Proveedor = nombre_Proveedor;
	}

	public String getRuc_Proveedor() {
		return ruc_Proveedor;
	}

	public void setRuc_Proveedor(String ruc_Proveedor) {
		this.ruc_Proveedor = ruc_Proveedor;
	}

	@Override
	public String toString() {
		return "Proveedor [id_Proveedor=" + id_Proveedor + ", nombre_Proveedor=" + nombre_Proveedor + ", ruc_Proveedor="
				+ ruc_Proveedor + "]";
	}
	
}
