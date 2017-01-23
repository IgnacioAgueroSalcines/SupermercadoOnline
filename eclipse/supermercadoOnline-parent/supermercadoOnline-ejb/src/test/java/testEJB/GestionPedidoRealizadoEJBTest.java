package testEJB;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;


import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.domain.LineaPedido;
import es.unican.ps.supermercadoOnline.domain.Pedido;
import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.negocio.GestionPedidoRealizadoEJB;
import es.unican.ps.supermercadoOnline.utils.IPedidoDAO;

public class GestionPedidoRealizadoEJBTest {

	private static  IPedidoDAO mock = mock(IPedidoDAO.class);
	private static GestionPedidoRealizadoEJB gestionTest;
	private static Usuario usuario;
	private static Pedido pedido;
	private static Pedido pedidoMock = mock(Pedido.class);
	private static LineaPedido linea;
	private static List<LineaPedido> lineas;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usuario=new Usuario();
		usuario.setId(1);
		pedido=new Pedido();
		pedido.setId(1);
		gestionTest= new GestionPedidoRealizadoEJB();
		gestionTest.setGestionPedido(mock);
		Articulo a=new Articulo("Tomates",2,0.5);
		linea=new LineaPedido(1,a);
		linea.setId(1);
		lineas = new ArrayList<LineaPedido>();
		lineas.add(linea);
		when(mock.addPedido(pedido)).thenReturn(pedido);
		when(pedidoMock.getLineasPedido()).thenReturn(lineas);
	}

	@Test
	public void initTest() {
		gestionTest.init(usuario);
		Usuario res=gestionTest.getUsuario();
		assertTrue(res.getId()==1);
	}
	
	@Test
	public void confirmPedidoTest() {
		gestionTest.init(usuario);
		gestionTest.setPedidoActual(pedido);
		Date horaRecogida=new Date();
		int res=gestionTest.confirmPedido(horaRecogida);
		assertTrue(res==1);
	}

	@Test
	public void addLineaPedidoTest() {
		gestionTest.init(usuario);
		gestionTest.setPedidoActual(pedido);
		LineaPedido res=gestionTest.addLineaPedido(linea);
		assertTrue(res.getId()==1);
	}

	@After
	public void tearDown() throws Exception {
	}

}
