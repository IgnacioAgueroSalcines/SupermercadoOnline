package es.unican.ps.supermercadoOnline.utils;

import javax.ejb.Remote;

import es.unican.ps.supermercadoOnline.domain.Articulo;


@Remote
public interface IUnidadesArticuloRemote {
	public int checkUnidadesStock (Articulo articulo);

}
