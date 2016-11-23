package es.unican.ps.supermercadoOnline.utils;

import javax.ejb.Remote;

import es.unican.ps.supermercadoOnline.domain.Pedido;

@Remote
public interface IPreparacionPedido {
	
	public Pedido processPedido();
	public double givePedido(Pedido pedido);

}
