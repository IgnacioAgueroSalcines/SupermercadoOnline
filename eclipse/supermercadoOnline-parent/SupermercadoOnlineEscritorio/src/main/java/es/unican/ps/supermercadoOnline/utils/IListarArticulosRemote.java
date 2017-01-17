package es.unican.ps.supermercadoOnline.utils;

import java.util.List;

import javax.ejb.Remote;

import es.unican.ps.supermercadoOnline.domain.Articulo;

@Remote
public interface IListarArticulosRemote {
	
	public List<Articulo> listArticulos();
	
	}
