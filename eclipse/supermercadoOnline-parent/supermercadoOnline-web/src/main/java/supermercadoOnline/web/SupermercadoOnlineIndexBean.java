package supermercadoOnline.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.utils.IRegistroUsuarioRemote;

@Named("supermercadoOnlineIndexBean")
@SessionScoped
public class SupermercadoOnlineIndexBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IRegistroUsuarioRemote remote;
	
	//valores vinculados a los facelets
	private String nombreCliente;
	
	
	
	public String getNombreCliente() {
		return nombreCliente;
	}



	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}



	//metodos de accion
	public String add(){
		Usuario res = new Usuario();
		res.setNombre(nombreCliente);
		remote.addUsuario(res);
		return "iniciaCompra.xhtml";
	}
}
