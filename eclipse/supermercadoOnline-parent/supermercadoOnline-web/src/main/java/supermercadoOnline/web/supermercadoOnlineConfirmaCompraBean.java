package supermercadoOnline.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.utils.IListarArticulosRemote;

@Named
@SessionScoped
public class supermercadoOnlineConfirmaCompraBean {
	@EJB
	private IListarArticulosRemote remote;
	@Inject
	public supermercadoOnlineIniciaCompraBean bean;
	@Inject
	public supermercadoOnlineTiendaWebBean bean2;

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
}
