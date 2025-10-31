package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Cliente;
	private String nombre_Cliente;
	private String ruc_Cliente;
	private String telefono_Cliente;
	
	
	
	public Cliente() {
		super();
	}



	public Cliente(Integer id_Cliente, String nombre_Cliente, String ruc_Cliente, String telefono_Cliente) {
		super();
		this.id_Cliente = id_Cliente;
		this.nombre_Cliente = nombre_Cliente;
		this.ruc_Cliente = ruc_Cliente;
		this.telefono_Cliente = telefono_Cliente;
	}



	public Integer getId_Cliente() {
		return id_Cliente;
	}



	public void setId_Cliente(Integer id_Cliente) {
		this.id_Cliente = id_Cliente;
	}



	public String getNombre_Cliente() {
		return nombre_Cliente;
	}



	public void setNombre_Cliente(String nombre_Cliente) {
		this.nombre_Cliente = nombre_Cliente;
	}



	public String getRuc_Cliente() {
		return ruc_Cliente;
	}



	public void setRuc_Cliente(String ruc_Cliente) {
		this.ruc_Cliente = ruc_Cliente;
	}



	public String getTelefono_Cliente() {
		return telefono_Cliente;
	}



	public void setTelefono_Cliente(String telefono_Cliente) {
		this.telefono_Cliente = telefono_Cliente;
	}



	@Override
	public String toString() {
		return "Cliente [id_Cliente=" + id_Cliente + ", nombre_Cliente=" + nombre_Cliente + ", ruc_Cliente="
				+ ruc_Cliente + ", telefono_Cliente=" + telefono_Cliente + "]";
	}
	
	
	
	
}
