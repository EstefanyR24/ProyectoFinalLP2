package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Producto;
	
	private String nombre_Producto;
	private double precio_Producto;
	private int stock_Producto;
	
    @ManyToOne
    @JoinColumn(name = "id_Proveedor")
    private Proveedor proveedor;

	public Producto() {
		super();
	}

	public Producto(Integer id_Producto, String nombre_Producto, double precio_Producto, int stock_Producto,
			Proveedor proveedor) {
		super();
		this.id_Producto = id_Producto;
		this.nombre_Producto = nombre_Producto;
		this.precio_Producto = precio_Producto;
		this.stock_Producto = stock_Producto;
		this.proveedor = proveedor;
	}

	public Integer getId_Producto() {
		return id_Producto;
	}

	public void setId_Producto(Integer id_Producto) {
		this.id_Producto = id_Producto;
	}

	public String getNombre_Producto() {
		return nombre_Producto;
	}

	public void setNombre_Producto(String nombre_Producto) {
		this.nombre_Producto = nombre_Producto;
	}

	public double getPrecio_Producto() {
		return precio_Producto;
	}

	public void setPrecio_Producto(double precio_Producto) {
		this.precio_Producto = precio_Producto;
	}

	public int getStock_Producto() {
		return stock_Producto;
	}

	public void setStock_Producto(int stock_Producto) {
		this.stock_Producto = stock_Producto;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Producto [id_Producto=" + id_Producto + ", nombre_Producto=" + nombre_Producto + ", precio_Producto="
				+ precio_Producto + ", stock_Producto=" + stock_Producto + ", proveedor=" + proveedor + "]";
	}
	
	
	
}
