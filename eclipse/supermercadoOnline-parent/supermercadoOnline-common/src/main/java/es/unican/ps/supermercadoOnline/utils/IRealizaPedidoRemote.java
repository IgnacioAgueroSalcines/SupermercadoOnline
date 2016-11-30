package es.unican.ps.supermercadoOnline.utils;

import javax.ejb.Remote;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.domain.LineaPedido;
import es.unican.ps.supermercadoOnline.domain.Pedido;
import es.unican.ps.supermercadoOnline.domain.Usuario;

@Remote
public interface IRealizaPedidoRemote {
	
	public int confirmPedido (Pedido pedido);
	public int checkUnidadesStock (Articulo articulo);
	public LineaPedido addLineaPedido (LineaPedido linea);
	public void init(Usuario usuario);

}