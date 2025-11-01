package com.ecommerce.sce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cotizacion")
public class Cotizacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Cotizacion;
	private String fecha_Cotizacion;
	private int num_Cotizacion;
	
	
	public Cotizacion() {
		super();
	}
	public Cotizacion(Integer id_Cotizacion, String fecha_Cotizacion, int num_Cotizacion) {
		super();
		this.id_Cotizacion = id_Cotizacion;
		this.fecha_Cotizacion = fecha_Cotizacion;
		this.num_Cotizacion = num_Cotizacion;
	}
	public Integer getId_Cotizacion() {
		return id_Cotizacion;
	}
	public void setId_Cotizacion(Integer id_Cotizacion) {
		this.id_Cotizacion = id_Cotizacion;
	}
	public String getFecha_Cotizacion() {
		return fecha_Cotizacion;
	}
	public void setFecha_Cotizacion(String fecha_Cotizacion) {
		this.fecha_Cotizacion = fecha_Cotizacion;
	}
	public int getNum_Cotizacion() {
		return num_Cotizacion;
	}
	public void setNum_Cotizacion(int num_Cotizacion) {
		this.num_Cotizacion = num_Cotizacion;
	}
	@Override
	public String toString() {
		return "Cotizacion [id_Cotizacion=" + id_Cotizacion + ", fecha_Cotizacion=" + fecha_Cotizacion
				+ ", num_Cotizacion=" + num_Cotizacion + "]";
	}
	
	
	
}
