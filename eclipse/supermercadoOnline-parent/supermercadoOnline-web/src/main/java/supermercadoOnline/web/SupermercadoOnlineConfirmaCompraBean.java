package supermercadoOnline.web;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.unican.ps.supermercadoOnline.utils.IListarArticulosRemote;

@Named ("supermercadoOnlineConfirmaCompraBean")
@SessionScoped
public class SupermercadoOnlineConfirmaCompraBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IListarArticulosRemote remote;
	@Inject
	private SupermercadoOnlineIniciaCompraBean bean;
	@Inject
	private SupermercadoOnlineTiendaWebBean bean2;

	//valores vinculados a los facelets
	private double precio;
	private double precioUnitario;
	private String nombreArticulo;

	//metodos de accion
	@PostConstruct
	public void init(){
		nombreArticulo=bean.getArticulo().getNombre();
		precioUnitario=bean.getArticulo().getPrecio();
		precio=bean2.getUnidades()*precioUnitario;
	}
	public String goEnd(){

		return "realizadaCompra.xhtml";
	}
	
	public String goBack(){

		return "iniciaCompra.xhtml";
	}
	
	public String goInit(){

		return "index.xhtml";
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public String getNombreArticulo() {
		return nombreArticulo;
	}
	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}
	
}
