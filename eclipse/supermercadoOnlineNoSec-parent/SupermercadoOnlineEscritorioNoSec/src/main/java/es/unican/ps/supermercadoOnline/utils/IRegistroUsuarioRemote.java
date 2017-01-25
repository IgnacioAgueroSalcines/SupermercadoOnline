package es.unican.ps.supermercadoOnline.utils;

import javax.ejb.Remote;

import es.unican.ps.supermercadoOnline.domain.Usuario;

@Remote
public interface IRegistroUsuarioRemote {
	
	public Usuario addUsuario (Usuario usuario);

}
