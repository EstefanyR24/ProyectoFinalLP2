package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Usuario;
	private String nombre_Usuario;
	private String telefono_Usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_Cargo")
	private Cargo cargo;

	public Usuario() {
		super();
	}

	public Usuario(Integer id_Usuario, String nombre_Usuario, String telefono_Usuario, Cargo cargo) {
		super();
		this.id_Usuario = id_Usuario;
		this.nombre_Usuario = nombre_Usuario;
		this.telefono_Usuario = telefono_Usuario;
		this.cargo = cargo;
	}

	public Integer getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getNombre_Usuario() {
		return nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		this.nombre_Usuario = nombre_Usuario;
	}

	public String getTelefono_Usuario() {
		return telefono_Usuario;
	}

	public void setTelefono_Usuario(String telefono_Usuario) {
		this.telefono_Usuario = telefono_Usuario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Usuario [id_Usuario=" + id_Usuario + ", nombre_Usuario=" + nombre_Usuario + ", telefono_Usuario="
				+ telefono_Usuario + ", cargo=" + cargo + "]";
	}

	
	
	
	
	
}
