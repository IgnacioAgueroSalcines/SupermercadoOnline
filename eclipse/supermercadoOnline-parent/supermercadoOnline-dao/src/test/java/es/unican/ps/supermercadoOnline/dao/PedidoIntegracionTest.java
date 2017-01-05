package es.unican.ps.supermercadoOnline.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import javax.ejb.embeddable.EJBContainer;
import javax.validation.constraints.AssertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.domain.LineaPedido;
import es.unican.ps.supermercadoOnline.domain.Pedido;
import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.utils.IRealizaPedidoRemote;

public class PedidoIntegracionTest {

	private static EJBContainer ec;
	private static IRealizaPedidoRemote remote;
	private Pedido pedido;

    @BeforeClass
    public static void initContainer() throws Exception {
        ec = EJBContainer.createEJBContainer();
        
        remote = (IRealizaPedidoRemote) ec.getContext().lookup("java:global/ejb-app/supermercadoOnline-dao-0.0.1-SNAPSHOT/");
    
   
    }
    
    @Before
	public void setUp() throws Exception {
    	Usuario usr = new Usuario();
		remote.init(usr);
	}
    
    @Test
	public void testAddLineaPedido() {
		LineaPedido linea= new LineaPedido();
		Articulo articulo = new Articulo();
		articulo.setNombre("patatas");
		articulo.setPrecio(2);
		articulo.setUnidadesStock(4);
		linea.setCantidad(2);
		LineaPedido res= remote.addLineaPedido(linea);
		assertTrue(res.getArticulo()==linea.getArticulo());
		assertTrue(res.getCantidad()==linea.getCantidad());
	
	}
    
 
    @AfterClass
    public static void closeContainer() throws Exception {
        //Cerramos el contenedor
        if (ec != null) {
            ec.close();
        }
    }
}
