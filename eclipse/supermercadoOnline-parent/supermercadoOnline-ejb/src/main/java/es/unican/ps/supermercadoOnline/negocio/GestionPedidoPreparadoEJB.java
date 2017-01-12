package es.unican.ps.supermercadoOnline.negocio;

import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;




import es.unican.ps.supermercadoOnline.domain.ComparatorPedido;
import es.unican.ps.supermercadoOnline.domain.EstadoPedido;
import es.unican.ps.supermercadoOnline.domain.Pedido;
import es.unican.ps.supermercadoOnline.utils.*;
@Stateless
public class GestionPedidoPreparadoEJB implements IPreparacionPedidoRemote{

	@EJB
	private IPedidoDAO gestionPedido;
	
	public Pedido processPedido() {
		Pedido pedido=pedidoPendiente();
		pedido.setEstado(EstadoPedido.PROCESADO);
		return gestionPedido.addPedido(pedido);

	}
	
	public Pedido pedidoPendiente(){
		List<Pedido> res = gestionPedido.listPedidos();
		Collections.sort(res,ComparatorPedido.getInstance());
		return res.get(0);
	}

	public void givePedido(Pedido pedido) {
			pedido.setEstado(EstadoPedido.ENTREGADO);
		
	}

	public Pedido getPedido(long id) {
		return gestionPedido.getPedido(id);
	}
	
}
