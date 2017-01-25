package es.unican.ps.supermercadoOnline.utils;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import es.unican.ps.supermercadoOnline.domain.Articulo;

@Remote
public interface IArticuloDAO {

	public Articulo addArticulo(Articulo articulo);
	public Articulo removeArticulo(Articulo articulo);
	public Articulo updateArticulo(Articulo articulo);
	public List<Articulo> listaArticulos();
	public Articulo getArticulo(long id);
}
