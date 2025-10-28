package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	private String nomProveedor;
	
	private String rucProveedor;

	public Proveedor() {
		super();
	}

	public Proveedor(Integer idProducto, String nomProveedor, String rucProveedor) {
		super();
		this.idProducto = idProducto;
		this.nomProveedor = nomProveedor;
		this.rucProveedor = rucProveedor;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public String getRucProveedor() {
		return rucProveedor;
	}

	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
	}

	@Override
	public String toString() {
		return "Proveedor [idProducto=" + idProducto + ", nomProveedor=" + nomProveedor + ", rucProveedor="
				+ rucProveedor + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
