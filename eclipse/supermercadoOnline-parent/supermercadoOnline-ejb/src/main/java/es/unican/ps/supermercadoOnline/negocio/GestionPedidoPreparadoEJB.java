package es.unican.ps.supermercadoOnline.negocio;

import java.util.Queue;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.domain.EstadoPedido;
import es.unican.ps.supermercadoOnline.domain.LineaPedido;
import es.unican.ps.supermercadoOnline.domain.Pedido;
import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.utils.*;
@Stateless
public class GestionPedidoPreparadoEJB implements IPreparacionPedidoRemote{

	@EJB
	private IPedidoDAO gestionPedido;
	
	//hacer cola priorizada por fecha, las que antes se recojan antes se hacen
	private static Queue<Pedido> cola;

	public Pedido processPedido() {
		Pedido pedido=cola.poll();
		pedido.setEstado(EstadoPedido.PROCESADO);
		return gestionPedido.addPedido(pedido);

	}

	public void givePedido(Pedido pedido) {
			pedido.setEstado(EstadoPedido.ENTREGADO);
		
	}

	public Pedido getPedido(long id) {
		return gestionPedido.getPedido(id);
	}
	
}
