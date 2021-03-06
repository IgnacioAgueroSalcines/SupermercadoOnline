package es.unican.ps.supermercadoOnline.negocio;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.utils.IExisteUsuarioRemote;
import es.unican.ps.supermercadoOnline.utils.IRegistroUsuarioRemote;
import es.unican.ps.supermercadoOnline.utils.IUsuarioDAO;

@Stateful
public class GestionUsuarioEJB implements IRegistroUsuarioRemote,IExisteUsuarioRemote
{

	@EJB
	private IUsuarioDAO gestionUsuario;
	
	public boolean exitsUsuario(String dni) {
		List<Usuario> lista=gestionUsuario.listaUsuarios();
		Boolean res=false;
		for(Usuario u: lista){
			if(u.getDni().equals(dni)){
				res=true;
			}
		}
		return res;
	}

	public Usuario addUsuario(Usuario usuario) {
		return gestionUsuario.addUsuario(usuario);
	}

	public Usuario getUsuario(String nombre) {
		return gestionUsuario.getUsuarioNombre(nombre);
	}

	

}
