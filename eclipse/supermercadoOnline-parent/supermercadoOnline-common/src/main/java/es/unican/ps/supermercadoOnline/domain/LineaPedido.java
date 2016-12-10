package es.unican.ps.supermercadoOnline.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LineaPedido {
	@Id
	private long id;
	private int cantidad;
	@OneToOne
	@JoinColumn(name="articulo_fk")
	private Articulo articulo;
	public LineaPedido(int cantidad, Articulo articulo) {
		super();
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
	public void setId(long id) {
		this.id = id;
	}

}
