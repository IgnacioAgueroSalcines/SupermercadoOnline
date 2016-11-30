package es.unican.ps.supermercadoOnline.negocio;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.domain.LineaPedido;
import es.unican.ps.supermercadoOnline.domain.Pedido;
import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.utils.*;
@Stateful
public class GestionPedidoRealizadoEJB implements IRealizaPedidoRemote{

	@EJB
	private IPedidoDAO gestionPedido;
	@EJB
	private IArticuloDAO gestionArticulo;
	
	private Pedido pedidoActual;

	private Usuario usuario;

	public int confirmPedido(Pedido pedido) {
		int res=0;
		
		return res;
	}

	public int checkUnidadesStock(Articulo articulo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public LineaPedido addLineaPedido(LineaPedido linea) {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(Usuario usuario) {
		this.usuario=usuario;
		this.pedidoActual=new Pedido();
	}





}
