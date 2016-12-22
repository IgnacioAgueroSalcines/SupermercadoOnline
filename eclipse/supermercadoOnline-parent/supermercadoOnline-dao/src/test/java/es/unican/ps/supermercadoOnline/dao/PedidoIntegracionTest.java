package es.unican.ps.supermercadoOnline.dao;

import javax.ejb.embeddable.EJBContainer;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import es.unican.ps.supermercadoOnline.utils.IRealizaPedidoRemote;

public class PedidoIntegracionTest {

	private static EJBContainer ec;
	private static IRealizaPedidoRemote remote;

    @BeforeClass
    public static void initContainer() throws Exception {
        ec = EJBContainer.createEJBContainer();
        
        remote = (IRealizaPedidoRemote) ec.getContext().lookup("java:global/ejb-app/supermercadoOnline-dao-0.0.1-SNAPSHOT/");
    
   
    }
 
    @AfterClass
    public static void closeContainer() throws Exception {
        //Cerramos el contenedor
        if (ec != null) {
            ec.close();
        }
    }
}
