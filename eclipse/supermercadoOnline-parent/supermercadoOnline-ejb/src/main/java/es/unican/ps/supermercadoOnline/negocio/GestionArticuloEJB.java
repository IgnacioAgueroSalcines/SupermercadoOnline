package es.unican.ps.supermercadoOnline.negocio;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.utils.IArticuloDAO;
import es.unican.ps.supermercadoOnline.utils.IGestionArticuloRemote;
@Stateless
public class GestionArticuloEJB implements IGestionArticuloRemote{
	
	@EJB
	private IArticuloDAO gestionArticulo;
	
	public Articulo addArticulo(Articulo articulo) {
		Articulo res=gestionArticulo.addArticulo(articulo);
		return res;
	}

	public Articulo removeArticulo(Articulo articulo) {
		Articulo res=gestionArticulo.removeArticulo(articulo);
		return res;
	}

	public Articulo uptadeArticulo(Articulo articulo) {
		Articulo res=gestionArticulo.updateArticulo(articulo);
		return res;
	}

}
