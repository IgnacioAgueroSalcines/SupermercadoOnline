package es.unican.ps.supermercadoOnline.domain;
public class LineaPedido {
	
	private static long idCont=0;
	private long id;
	private int cantidad;
	private Articulo articulo;
	public LineaPedido(int cantidad, Articulo articulo) {
		super();
		id=idCont++;
		this.cantidad = cantidad;
		this.articulo = articulo;
	}
	public long getId() {
		return id;
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
