package es.unican.ps.supermercadoOnline.domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {




	private long id; 
	private EstadoPedido estado;
	private Date fecha;
	private Date horaRecogida ;
	private Usuario usuario;
	private List<LineaPedido> lineasPedido;

	public Pedido(){
		this.estado =EstadoPedido.PENDIENTE;
		this.lineasPedido = new ArrayList<LineaPedido>();
	}

	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public EstadoPedido getEstado() {
		return estado;
	}


	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Date getHoraRecogida() {
		return horaRecogida;
	}


	public void setHoraRecogida(Date horaRecogida) {
		this.horaRecogida = horaRecogida;
	}
	public Usuario getUsuario() {
		return usuario;
	}





	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}





	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}





	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
}
