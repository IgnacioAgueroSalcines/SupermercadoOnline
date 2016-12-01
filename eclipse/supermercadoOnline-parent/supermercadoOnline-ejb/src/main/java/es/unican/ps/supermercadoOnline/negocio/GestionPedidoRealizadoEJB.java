package es.unican.ps.supermercadoOnline.negocio;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import es.unican.ps.supermercadoOnline.domain.LineaPedido;
import es.unican.ps.supermercadoOnline.domain.Pedido;
import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.utils.*;
@Stateful
public class GestionPedidoRealizadoEJB implements IRealizaPedidoRemote{

	@EJB
	private IPedidoDAO gestionPedido;
	
	
	private Pedido pedidoActual;

	private Usuario usuario;

	


	public void init(Usuario usuario) {
		this.usuario=usuario;
		this.pedidoActual=new Pedido();
	}

	public int confirmPedido(Date horaRecogida) {
		Date date = new Date();
		pedidoActual.setFecha(date);
		pedidoActual.setHoraRecogida(horaRecogida);
		pedidoActual.setUsuario(usuario);
		Pedido res= gestionPedido.addPedido(pedidoActual);
		return (int)res.getId();
	}

	public LineaPedido addLineaPedido(LineaPedido linea) {
		pedidoActual.getLineasPedido().add(linea);
		return linea;
	}





}
