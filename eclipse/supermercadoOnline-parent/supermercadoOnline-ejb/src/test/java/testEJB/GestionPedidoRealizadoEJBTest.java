package testEJB;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.enterprise.admin.servermgmt.xml.stringsubs.Archive;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.domain.LineaPedido;
import es.unican.ps.supermercadoOnline.domain.Pedido;
import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.negocio.GestionPedidoRealizadoEJB;
import es.unican.ps.supermercadoOnline.utils.IPedidoDAO;

public class GestionPedidoRealizadoEJBTest {

	private static  IPedidoDAO mock = mock(IPedidoDAO.class);
	private static GestionPedidoRealizadoEJB gestionTest;
	private static GestionPedidoRealizadoEJB gestionMock=mock(GestionPedidoRealizadoEJB.class);
	private static Usuario usuario;
	private static Pedido pedido;
	private static LineaPedido linea;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		when(mock.addPedido(pedido)).thenReturn(pedido);
		when(gestionMock.addLineaPedido(linea)).thenReturn(linea);
	}

	@Before
	public void setUpBefore() throws Exception {
		gestionTest= new GestionPedidoRealizadoEJB();
		usuario=new Usuario();
		pedido=new Pedido();
		gestionTest.init(usuario);
		gestionTest.setGestionPedido(mock);
		gestionTest.setPedidoActual(pedido);

	}


	@Test
	public void confirmPedidoTest() {
		Date horaRecogida=new Date();
		int res=gestionTest.confirmPedido(horaRecogida);
		assertTrue(res==0);
	}

	@Test
	public void addLineaPedidoTest() {
		Articulo a=new Articulo("Tomates",2,0.5);
		linea=new LineaPedido(1,a);
		LineaPedido res=gestionTest.addLineaPedido(linea);
		assertTrue(res.getId()==0);
	}

	@After
	public void tearDown() throws Exception {
	}

}