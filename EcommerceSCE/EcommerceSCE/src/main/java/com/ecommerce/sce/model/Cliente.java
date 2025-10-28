package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	private String nomCliente;
	private String rucCliente;
	private String telefonoCliente;
	
	
	public Cliente(Integer idCliente, String nomCliente, String rucCliente, String telefonoCliente) {
		super();
		this.idCliente = idCliente;
		this.nomCliente = nomCliente;
		this.rucCliente = rucCliente;
		this.telefonoCliente = telefonoCliente;
	}
	public Cliente() {
		super();
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public String getRucCliente() {
		return rucCliente;
	}
	public void setRucCliente(String rucCliente) {
		this.rucCliente = rucCliente;
	}
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomCliente=" + nomCliente + ", rucCliente=" + rucCliente
				+ ", telefonoCliente=" + telefonoCliente + "]";
	}
	
	
	
	
}
