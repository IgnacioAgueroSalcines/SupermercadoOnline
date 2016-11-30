package es.unican.ps.supermercadoOnline.domain;


import java.util.List;

public class Tienda {
	
	private List<Usuario> usuariosRegistrados;
	private List<Pedido> pedidos;
	private List <Articulo> articulosDisponibles;
	public Tienda(List<Usuario> usuariosRegistrados, List<Pedido> pedidos,
			List<Articulo> articulosDisponibles) {
		super();
		this.usuariosRegistrados = usuariosRegistrados;
		this.pedidos = pedidos;
		this.articulosDisponibles = articulosDisponibles;
	}
	public List<Usuario> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}
	public void setUsuariosRegistrados(List<Usuario> usuariosRegistrados) {
		this.usuariosRegistrados = usuariosRegistrados;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public List<Articulo> getArticulosDisponibles() {
		return articulosDisponibles;
	}
	public void setArticulosDisponibles(List<Articulo> articulosDisponibles) {
		this.articulosDisponibles = articulosDisponibles;
	}
	
	

}