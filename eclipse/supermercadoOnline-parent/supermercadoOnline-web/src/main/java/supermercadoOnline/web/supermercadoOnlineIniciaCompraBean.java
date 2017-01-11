package supermercadoOnline.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;





import org.apache.taglibs.standard.lang.jstl.test.Bean1;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.domain.Usuario;
import es.unican.ps.supermercadoOnline.utils.IGestionArticuloRemote;
import es.unican.ps.supermercadoOnline.utils.IListarArticulosRemote;
import es.unican.ps.supermercadoOnline.utils.IRegistroUsuarioRemote;

@Named
@SessionScoped
public class supermercadoOnlineIniciaCompraBean {
	@EJB
	private IListarArticulosRemote listar;
	@EJB
	private IGestionArticuloRemote gestion;
	@ManagedProperty("#{supermercadoOnlineTiendaWebBean}")
	private Bean1 bean1;

	//valores vinculados a los facelets
	private String nombre;
	private double precio;
	private List<Articulo> listaArticulos;
	private Articulo articulo;


	//metodos de accion
	public Articulo getArticulo(){
		return articulo;
	}
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
}
