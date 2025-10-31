package com.ecommerce.sce.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Pedido")
public class Pedido {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_Pedido")
	    private Integer id_Pedido;

	    @ManyToMany
	    @JoinTable(
	        name = "pedido_producto",
	        joinColumns = @JoinColumn(name = "id_Pedido"),
	        inverseJoinColumns = @JoinColumn(name = "id_Producto")
	    )
	    private List<Producto> productos;

	    @ManyToOne
	    @JoinColumn(name = "id_Cliente")
	    private Cliente cliente;

	    @ManyToOne
	    @JoinColumn(name = "id_Usuario")
	    private Usuario usuario;

	    @ManyToOne
	    @JoinColumn(name = "id_Cotizacion")
	    private Cotizacion cotizacion;

	    @Column(name = "fecha_Pedido")
	    private String fecha_Pedido;

		public Pedido() {
			super();
		}

		public Pedido(Integer id_Pedido, List<Producto> productos, Cliente cliente, Usuario usuario,
				Cotizacion cotizacion, String fecha_Pedido) {
			super();
			this.id_Pedido = id_Pedido;
			this.productos = productos;
			this.cliente = cliente;
			this.usuario = usuario;
			this.cotizacion = cotizacion;
			this.fecha_Pedido = fecha_Pedido;
		}

		public Integer getId_Pedido() {
			return id_Pedido;
		}

		public void setId_Pedido(Integer id_Pedido) {
			this.id_Pedido = id_Pedido;
		}

		public List<Producto> getProductos() {
			return productos;
		}

		public void setProductos(List<Producto> productos) {
			this.productos = productos;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
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

		public String getFecha_Pedido() {
			return fecha_Pedido;
		}

		public void setFecha_Pedido(String fecha_Pedido) {
			this.fecha_Pedido = fecha_Pedido;
		}

		@Override
		public String toString() {
			return "Pedido [id_Pedido=" + id_Pedido + ", productos=" + productos + ", cliente=" + cliente + ", usuario="
					+ usuario + ", cotizacion=" + cotizacion + ", fecha_Pedido=" + fecha_Pedido + "]";
		}

	
	
}
