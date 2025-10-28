package com.ecommerce.sce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedido;
	
	@OneToMany (mappedBy = "usuario")
	private List<Productos> producto;
	
	@OneToOne (mappedBy = "usuario")
	private Cliente cliente;
	
	private String fechaPedido;
	
	@OneToOne (mappedBy = "usuario")
	private Usuario usuario;
	
	@OneToOne (mappedBy = "usuario")
	private Cotizacion cotizacion;

	public Pedido(Integer idPedido, List<Productos> producto, Cliente cliente, String fechaPedido, Usuario usuario,
			Cotizacion cotizacion) {
		super();
		this.idPedido = idPedido;
		this.producto = producto;
		this.cliente = cliente;
		this.fechaPedido = fechaPedido;
		this.usuario = usuario;
		this.cotizacion = cotizacion;
	}

	public Pedido() {
		super();
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public List<Productos> getProducto() {
		return producto;
	}

	public void setProducto(List<Productos> producto) {
		this.producto = producto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", producto=" + producto + ", cliente=" + cliente + ", fechaPedido="
				+ fechaPedido + ", usuario=" + usuario + ", cotizacion=" + cotizacion + "]";
	}
	
	
	
	
	
	
	
}
