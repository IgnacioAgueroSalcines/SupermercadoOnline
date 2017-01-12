package es.unican.ps.supermercadoOnline.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.utils.IArticuloDAO;
import es.unican.ps.supermercadoOnline.utils.IGestionArticuloRemote;
import es.unican.ps.supermercadoOnline.utils.IListarArticulosRemote;
@Stateless
public class ListarArticulosEJB implements IListarArticulosRemote{
	
	@EJB
	private IArticuloDAO gestionArticulo;

	public List<Articulo> listArticulos() {
		return gestionArticulo.listaArticulos();
	}
	
	
}
