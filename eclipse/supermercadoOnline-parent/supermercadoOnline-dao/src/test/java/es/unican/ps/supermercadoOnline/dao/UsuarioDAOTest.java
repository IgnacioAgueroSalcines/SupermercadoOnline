package es.unican.ps.supermercadoOnline.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.ps.supermercadoOnline.domain.Usuario;

public class UsuarioDAOTest {
	
	private static UsuarioDAO  dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao=new UsuarioDAO();
	}
	


	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		Usuario usuario=new Usuario();
		Usuario res=dao.addElement(usuario);
		assertTrue(res.getId()==usuario.getId());
	}

}