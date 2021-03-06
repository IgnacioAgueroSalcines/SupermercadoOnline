package es.unican.ps.supermercadoOnline.dao;

import static org.mockito.Mockito.*;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.ps.supermercadoOnline.domain.EstadoPedido;
import es.unican.ps.supermercadoOnline.domain.Pedido;


public class PedidoDAOTest {
	
	private static PedidoDAO dao;
	private static Pedido pedido;
	private static  EntityManager mock = mock(EntityManager.class);
	private static Query query=mock(Query.class);
	

	@Before
	public void setUp() throws Exception {
		dao=new PedidoDAO();
		dao.setEM(mock);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		when(mock.createQuery("SELECT t FROM Pedido t"))
		.thenReturn(query);
	}

	@Test
	public void testAdd() {
		pedido=new Pedido();
		dao.addElement(pedido);
		verify(mock).persist(pedido);
	
	}
	
	@Test
	public void testRemove() {
		pedido=new Pedido();
		Pedido res= dao.addElement(pedido);
		
		dao.removeElement(res);
		verify(mock).merge(res);

		res=dao.getElement(res.getId());
		
		verify(mock).remove(res);
	
	}
	
	@Test
	public void testUpdate() {
		pedido=new Pedido();
		Pedido res= dao.addElement(pedido);
		
		res.setEstado(EstadoPedido.PROCESADO);
		res=dao.updateElement(res);
		
		verify(mock).merge(res);
	
	}
	
	@Test
	public void testLista() {
		pedido=new Pedido();
		dao.addElement(pedido);
		
		dao.listaElement();
		
		verify(mock).createQuery("SELECT t FROM Pedido t");
	}

}
