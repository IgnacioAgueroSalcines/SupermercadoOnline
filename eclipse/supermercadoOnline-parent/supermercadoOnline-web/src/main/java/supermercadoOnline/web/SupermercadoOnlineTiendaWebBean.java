package supermercadoOnline.web;


import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.domain.LineaPedido;

@Named ("supermercadoOnlineTiendaWebBean")
@SessionScoped
public class SupermercadoOnlineTiendaWebBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Inject
	private SupermercadoOnlineIniciaCompraBean bean;
	@Inject
	private SupermercadoOnlineConfirmaCompraBean bean2;



	//valores vinculados a los facelets
	
	private List<Articulo> carro;
	private List<Integer> unidadesCarrito;
	private Articulo articulo;
	private int unidades;


	//metodos de accion


	public String add(){
		Articulo prov = bean.getArticulo();
		
		LineaPedido linea = new LineaPedido();
		linea.setArticulo(prov);
		linea.setCantidad(unidades); 
		//persist de la linea

		bean2.getRemote2().addLineaPedido(linea);
		
		//relleno listas que seran visualizadas
		carro.add(prov);
		unidadesCarrito.add(unidades);

		unidades = 0;

		return "confirmaCompra.xhtml";
	}
	public String goBack(){
		return "iniciaCompra.xhtml";
	}

	//metodos observadores
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
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
}
