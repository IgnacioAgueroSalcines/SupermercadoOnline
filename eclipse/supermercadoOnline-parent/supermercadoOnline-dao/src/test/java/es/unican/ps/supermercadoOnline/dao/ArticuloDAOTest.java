package es.unican.ps.supermercadoOnline.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.ps.supermercadoOnline.domain.Articulo;

public class ArticuloDAOTest {

	
	
	private ArticuloDAO dao;

	@Before
	public void setUp() throws Exception {
		dao=new ArticuloDAO();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		Articulo articulo=new Articulo();
		Articulo res=dao.addElement(articulo);
		assertTrue(articulo.getId()==res.getId());
		}

}
