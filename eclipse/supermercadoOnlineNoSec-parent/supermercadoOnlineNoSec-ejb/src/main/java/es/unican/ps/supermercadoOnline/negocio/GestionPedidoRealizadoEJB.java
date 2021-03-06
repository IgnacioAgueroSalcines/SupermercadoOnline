package es.unican.ps.supermercadoOnline.negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remove;
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
	@Remove
	public int confirmPedido(Date horaRecogida) {
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		pedidoActual.setUsuario(usuario);
		pedidoActual.setFecha(date);
		pedidoActual.setHoraRecogida(horaRecogida);
		Pedido res= gestionPedido.addPedido(pedidoActual);
		return (int)res.getId();
	}

	public LineaPedido addLineaPedido(LineaPedido linea) {
		LineaPedido res=null;
		//a�adir linea
		List<LineaPedido> list=pedidoActual.getLineasPedido();
		if(list==null){
			list = new ArrayList<LineaPedido>();
		}
		list.add(linea);

		pedidoActual.setLineasPedido(list);
		
		for(LineaPedido l : list){
			if(l.getId()==linea.getId())
				res= l;
		}
		
		return res;
	}




	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public IPedidoDAO getGestionPedido() {
		return gestionPedido;
	}

	public void setGestionPedido(IPedidoDAO gestionPedido) {
		this.gestionPedido = gestionPedido;
	}

	

	public Pedido getPedidoActual() {
		return pedidoActual;
	}

	public void setPedidoActual(Pedido pedidoActual) {
		this.pedidoActual = pedidoActual;
	}



}
