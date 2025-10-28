package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cotizacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCot;
	
	private String fechaCot;
	private String numCotizacion;
	
	public Cotizacion(Integer idCot, String fechaCot, String numCotizacion) {
		super();
		this.idCot = idCot;
		this.fechaCot = fechaCot;
		this.numCotizacion = numCotizacion;
	}
	
	public Cotizacion() {
		super();
	}

	public Integer getIdCot() {
		return idCot;
	}

	public void setIdCot(Integer idCot) {
		this.idCot = idCot;
	}

	public String getFechaCot() {
		return fechaCot;
	}

	public void setFechaCot(String fechaCot) {
		this.fechaCot = fechaCot;
	}

	public String getNumCotizacion() {
		return numCotizacion;
	}

	public void setNumCotizacion(String numCotizacion) {
		this.numCotizacion = numCotizacion;
	}

	@Override
	public String toString() {
		return "Cotizacion [idCot=" + idCot + ", fechaCot=" + fechaCot + ", numCotizacion=" + numCotizacion + "]";
	}
	
	
	
	
	
	
	
	
	
}
