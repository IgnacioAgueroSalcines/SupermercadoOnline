package es.unican.ps.supermercadoOnline.utils;

import java.util.List;
import java.util.Queue;

import javax.ejb.Remote;

import es.unican.ps.supermercadoOnline.domain.Pedido;

@Remote
public interface IPedidoDAO {
	public Pedido addPedido(Pedido pedido);
	public Pedido removePedido(Pedido pedido);
	public Pedido updatePedido(Pedido pedido);
	public List<Pedido> listPedidos();
	public Pedido getPedido(long id);
}
