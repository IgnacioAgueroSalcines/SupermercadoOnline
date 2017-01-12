package supermercadoOnline.web;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;import javax.inject.Inject;
import javax.inject.Named;

import es.unican.ps.supermercadoOnline.utils.IListarArticulosRemote;

@Named
@SessionScoped
public class SupermercadoOnlineTiendaWebBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IListarArticulosRemote remote;

	//valores vinculados a los facelets
	private int unidades;
	private String nombreArticulo;
	@Inject
	private SupermercadoOnlineIniciaCompraBean bean;

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
	public String getNombreArticulo() {
		return nombreArticulo;
	}
	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
}
