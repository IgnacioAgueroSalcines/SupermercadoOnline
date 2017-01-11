package supermercadoOnline.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.utils.IListarArticulosRemote;

@Named
@SessionScoped
public class supermercadoOnlineTiendaWebBean {
	@EJB
	private IListarArticulosRemote remote;

	//valores vinculados a los facelets
	private int unidades;
	private String nombreArticulo;
	@Inject
	public supermercadoOnlineIniciaCompraBean bean;

	//metodos de accion
	@PostConstruct
	public void init(){
		nombreArticulo=bean.getArticulo().getNombre();
	}
	public int getUnidades(){
		return unidades;
	}
	public String add(){

		return "confirmaCompra.xhtml";
	}
	
	public String goBack(){

		return "iniciaCompra.xhtml";
	}
}
