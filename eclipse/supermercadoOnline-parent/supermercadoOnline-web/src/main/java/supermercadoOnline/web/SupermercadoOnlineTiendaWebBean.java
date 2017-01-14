package supermercadoOnline.web;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.utils.IListarArticulosRemote;

@Named ("supermercadoOnlineTiendaWebBean")
@SessionScoped
public class SupermercadoOnlineTiendaWebBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@EJB
	private IListarArticulosRemote remote;
	@Inject
	private SupermercadoOnlineIniciaCompraBean bean;
	

	//valores vinculados a los facelets
	private int unidades;
	private String nombreArticulo;
	private List<Articulo> carro;
	private List<Integer> unidadesCarrito;
	private Articulo articulo;
	

	//metodos de accion
	@PostConstruct
	public void init(){
		nombreArticulo=bean.getArticulo().getNombre();
	}
	
	public String add(){
		Articulo prov = bean.getArticulo();
		Articulo a = new Articulo();
		a.setNombre(prov.getNombre());
		a.setPrecio(prov.getPrecio());
		
		List<Articulo> res= new LinkedList<Articulo>();
		List<Integer> listaunidades= new LinkedList<Integer>();
		if(carro!=null && unidadesCarrito!=null){
			res.addAll(carro);
			listaunidades.addAll(unidadesCarrito);
		}
		res.add(a);
		listaunidades.add((Integer)unidades);
		carro = res;
		unidadesCarrito=listaunidades;
		
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
	public int getUnidades(){
		return unidades;
	}
	public List<Articulo> getCarro() {
		return carro;
	}
	public void setCarro(List<Articulo> carro) {
		this.carro = carro;
	}
	public List<Integer> getUnidadesCarrito() {
		return unidadesCarrito;
	}
	public void setUnidadesCarrito(List<Integer> unidadesCarrito) {
		this.unidadesCarrito = unidadesCarrito;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
}
