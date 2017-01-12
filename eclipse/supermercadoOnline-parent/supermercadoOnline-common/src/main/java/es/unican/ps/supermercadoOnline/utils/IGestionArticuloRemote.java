package es.unican.ps.supermercadoOnline.utils;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import es.unican.ps.supermercadoOnline.domain.Articulo;


@Remote
public interface IGestionArticuloRemote {
	public Articulo addArticulo(Articulo articulo);
	public Articulo removeArticulo (Articulo articulo);
	public Articulo updateArticulo (Articulo articulo);
	public Articulo getArticulo(long id);
}
