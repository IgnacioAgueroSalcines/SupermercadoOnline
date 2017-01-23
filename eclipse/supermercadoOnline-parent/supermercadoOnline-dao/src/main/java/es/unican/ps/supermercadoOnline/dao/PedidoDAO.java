package es.unican.ps.supermercadoOnline.dao;

import java.util.List;

import javax.ejb.Stateless;

import es.unican.ps.supermercadoOnline.domain.Pedido;
import es.unican.ps.supermercadoOnline.utils.GenericDAO;
import es.unican.ps.supermercadoOnline.utils.IPedidoDAO;

@Stateless
public class PedidoDAO extends GenericDAO<Pedido> implements IPedidoDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Pedido addPedido(Pedido pedido) {
		return this.addElement(pedido);
	}

	public Pedido removePedido(Pedido pedido) {
		return this.removeElement(pedido);
	}

	public Pedido updatePedido(Pedido pedido) {
		return this.updateElement(pedido);
	}

	public List<Pedido> listPedidos() {
		return this.listaElement();
	}

	

	public Pedido getPedido(long id) {
		return this.getElement(id);
	}

	
	

	
}
