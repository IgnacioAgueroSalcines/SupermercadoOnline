package es.unican.ps.supermercadoOnline.dao;


import java.util.List;

import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.utils.GenericDAO;
import es.unican.ps.supermercadoOnline.utils.IUsuarioDAO;




import javax.ejb.Stateless;
import javax.persistence.Query;


@Stateless
public class UsuarioDAO extends GenericDAO<Usuario> implements IUsuarioDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Usuario addUsuario(Usuario usuario) {
		return this.addElement(usuario);
	}

	public Usuario removeUsuario(Usuario usuario) {
		return this.removeElement(usuario);
	}

	public Usuario updateUsuario(Usuario usuario) {
		return this.updateElement(usuario);
	}

	public List<Usuario> listaUsuarios() {
		return this.listaElement();
	}

	public Usuario getUsuario(long id) {
		return this.getElement(id);
	}

	public Usuario getUsuarioNombre(String nombre) {
		Usuario res=null;
		
		Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre='"+nombre+"'");
		res= (Usuario)query.getSingleResult() ;
		
		return res;
	}

	

}
