package es.unican.ps.supermercadoOnline.utils;

import javax.ejb.Remote;



@Remote
public interface IExisteUsuarioRemote {
	public boolean exitsUsuario(String dni);
}
