package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "usuario")
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	private String nomProducto;
	private double precio;
	private int stock;
	
	@ManyToOne
	private Proveedor proveedor;

	public Productos(Integer idProducto, String nomProducto, double precio, int stock, Proveedor proveedor) {
		super();
		this.idProducto = idProducto;
		this.nomProducto = nomProducto;
		this.precio = precio;
		this.stock = stock;
		this.proveedor = proveedor;
	}

	public Productos() {
		super();
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Productos [idProducto=" + idProducto + ", nomProducto=" + nomProducto + ", precio=" + precio
				+ ", stock=" + stock + ", provedor=" + proveedor + "]";
	}
	
	
	
	
}
