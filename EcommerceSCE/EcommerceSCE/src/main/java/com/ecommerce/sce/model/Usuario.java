package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	private String nombreUsuario;
	private String telUsuario;
	
	@OneToOne
	private Cargo cargo;

	public Usuario(Integer idUsuario, String nombreUsuario, String telUsuario, Cargo cargo) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.telUsuario = telUsuario;
		this.cargo = cargo;
	}

	public Usuario() {
		super();
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getTelUsuario() {
		return telUsuario;
	}

	public void setTelUsuario(String telUsuario) {
		this.telUsuario = telUsuario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", telUsuario=" + telUsuario
				+ ", cargo=" + cargo + "]";
	}
	
	
	
	
	
	
}
