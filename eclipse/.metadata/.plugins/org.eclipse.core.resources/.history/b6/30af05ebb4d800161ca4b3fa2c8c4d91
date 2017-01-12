package supermercadoOnline.web;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.utils.IRegistroUsuarioRemote;

@Named
@SessionScoped
public class supermercadoOnlineIndexBean {
	@EJB
	private IRegistroUsuarioRemote remote;
	
	//valores vinculados a los facelets
	private String nombreCliente;
	
	//metodos de accion
	public String add(){
		Usuario res = new Usuario();
		res.setNombre(nombreCliente);
		remote.addUsuario(res);
		return "iniciaCompra.xhtml";
	}
}
