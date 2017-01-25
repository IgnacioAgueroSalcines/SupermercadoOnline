package main;

import javax.ejb.EJB;

import es.unican.ps.supermercadoOnline.utils.IPreparacionPedidoRemote;
import es.unican.ps.supermercadoOnline.utils.IRealizaPedidoRemote;
import vista.VentanaDependientes;




public class Main {
	@EJB
	private static IPreparacionPedidoRemote preparacion;
	@EJB
	private static IRealizaPedidoRemote realiza;
	
	public Main() {
		super();
		
	}
	
	public static void main(String[] args) {
		new Main();
		new VentanaDependientes(preparacion,realiza);
	}

}