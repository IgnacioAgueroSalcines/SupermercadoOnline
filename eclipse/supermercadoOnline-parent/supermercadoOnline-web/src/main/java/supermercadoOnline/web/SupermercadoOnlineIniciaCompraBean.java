package supermercadoOnline.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;










import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.utils.IGestionArticuloRemote;
import es.unican.ps.supermercadoOnline.utils.IListarArticulosRemote;

@Named ("supermercadoOnlineIniciaCompraBean")
@SessionScoped
public class SupermercadoOnlineIniciaCompraBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IListarArticulosRemote listar;
	@EJB
	private IGestionArticuloRemote gestion;
	//valores vinculados a los facelets
	private String nombre;
	private double precio;
	private List<Articulo> listaArticulos;
	private Articulo articulo;


	//metodos de accion
	public String add(long id){
		articulo=gestion.getArticulo(id);
		return "tiendaWeb.xhtml";
	}

	public String list(){


		return "confirmaCompra.xhtml";
	}


	@PostConstruct
	public void init(){
		listaArticulos = listar.listArticulos();
	}
	
	//metodos observadores
	public Articulo getArticulo(){
		return articulo;
	}
	public IListarArticulosRemote getListar() {
		return listar;
	}
	public void setListar(IListarArticulosRemote listar) {
		this.listar = listar;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public IGestionArticuloRemote getGestion() {
		return gestion;
	}
	public void setGestion(IGestionArticuloRemote gestion) {
		this.gestion = gestion;
	}
	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}
	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
	
}
