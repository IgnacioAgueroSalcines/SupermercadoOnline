package es.unican.ps.supermercadoOnline.negocio;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.domain.LineaPedido;
import es.unican.ps.supermercadoOnline.domain.Pedido;
import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.utils.*;
@Stateful
public class GestionPedidoPreparadoEJB implements IPreparacionPedidoRemote{

	@EJB
	private IPedidoDAO gestionPedido;

	public Pedido processPedido() {
		// TODO Auto-generated method stub
		return null;
	}

	public double givePedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}