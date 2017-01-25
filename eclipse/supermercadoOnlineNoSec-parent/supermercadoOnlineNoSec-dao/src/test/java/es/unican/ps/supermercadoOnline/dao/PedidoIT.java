package es.unican.ps.supermercadoOnline.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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
import es.unican.ps.supermercadoOnline.utils.IPedidoDAO;
import es.unican.ps.supermercadoOnline.utils.IRealizaPedidoRemote;
import es.unican.ps.supermercadoOnline.utils.IUsuarioDAO;

public class PedidoIT {

	private static EJBContainer ec;
	private static IPedidoDAO remotePedido;
	private static IUsuarioDAO remoteUsuario;
	private Pedido pedido;

    @BeforeClass
    public static void initContainer() throws Exception {
    	Map properties = new HashMap();
    	 properties.put(EJBContainer.MODULES, new File[]{new File("classes")});

    	 properties.put("org.glassfish.ejb.embedded.glassfish.installation.root",
    	 "C:/glassfish4/glassfish");
        ec = EJBContainer.createEJBContainer(properties);
        
        remotePedido = (IPedidoDAO) ec.getContext().lookup("java:global/supermercadoOnline-dao-0.0.1-SNAPSHOT/PedidoDAO");
        remoteUsuario = (IUsuarioDAO) ec.getContext().lookup("java:global/supermercadoOnline-dao-0.0.1-SNAPSHOT/UsuarioDAO");
    
   
    }
    
    @Test
	public void testAddPedido() {
		Pedido pedido = new Pedido();
		Usuario usr = remoteUsuario.getUsuario(1);
		pedido.setUsuario(usr);
		Pedido res = remotePedido.addPedido(pedido);
		assertTrue(res.getUsuario().getNombre().equals(usr.getNombre()));

	
	}
    
 
    @AfterClass
    public static void closeContainer() throws Exception {
        //Cerramos el contenedor
        if (ec != null) {
            ec.close();
        }
    }
}