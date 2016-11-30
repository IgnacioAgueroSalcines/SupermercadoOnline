package es.unican.ps.supermercadoOnline.domain;
public class LineaPedido {
	
	private long id;
	private int cantidad;
	private Articulo articulo;
	public LineaPedido(long id, int cantidad, Articulo articulo) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.articulo = articulo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

}