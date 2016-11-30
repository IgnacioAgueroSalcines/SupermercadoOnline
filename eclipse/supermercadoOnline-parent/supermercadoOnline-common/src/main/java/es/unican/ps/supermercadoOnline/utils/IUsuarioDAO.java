package es.unican.ps.supermercadoOnline.utils;

import java.util.List;

import javax.ejb.Remote;

import es.unican.ps.supermercadoOnline.domain.Usuario;

@Remote
public interface IUsuarioDAO {

	public Usuario addUsuario(Usuario usuario);
	public Usuario removeUsuario(Usuario usuario);
	public Usuario updateUsuario(Usuario usuario);
	public List<Usuario> listaUsuario(Usuario usuario);
	public Usuario getUsuario(String id);
}
