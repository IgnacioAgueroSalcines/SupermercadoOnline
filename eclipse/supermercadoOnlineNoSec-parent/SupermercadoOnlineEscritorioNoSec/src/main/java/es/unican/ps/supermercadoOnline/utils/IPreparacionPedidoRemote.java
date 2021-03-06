package es.unican.ps.supermercadoOnline.utils;

import javax.ejb.Remote;

import es.unican.ps.supermercadoOnline.domain.Pedido;

@Remote
public interface IPreparacionPedidoRemote {
	
	public Pedido processPedido();
	public void givePedido(Pedido pedido);
	public Pedido getPedido(long id);

}
