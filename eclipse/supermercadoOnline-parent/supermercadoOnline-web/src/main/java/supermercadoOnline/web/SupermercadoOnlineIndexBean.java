package supermercadoOnline.web;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ejb.SessionContext;

import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.utils.IRegistroUsuarioRemote;

@Named("supermercadoOnlineIndexBean")
@SessionScoped
@DeclareRoles({"USUARIOREGISTRADO","GERENTE","DEPENDIENTE","USUARIO"})
public class SupermercadoOnlineIndexBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private SessionContext ctx;

	@EJB
	private IRegistroUsuarioRemote remote;

	//valores vinculados a los facelets
	private String nombreCliente;


	@RolesAllowed("USUARIOREGISTRADO")
	public String getNombreCliente() {
		return nombreCliente;
	}


	@RolesAllowed("USUARIOREGISTRADO")
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}



	//metodos de accion
	@RolesAllowed("USUARIOREGISTRADO")
	public String add(){
		String res ="index.xhtml";
		if (ctx.isCallerInRole("GERENTE")) {
			res="gerencia.xhtml";
		}else if(ctx.isCallerInRole("USUARIO")){
			res="registry.xhtml";

		}else if(ctx.isCallerInRole("DEPENDIENTE")){
			res="dependencia.xhtml";

		}else if(ctx.isCallerInRole("USUARIOREGISTRADO")){
			Usuario res2 = new Usuario();
			res2.setNombre(nombreCliente);
			remote.addUsuario(res2);
			res="iniciaCompra.xhtml";
		}

		return res;
	}
}