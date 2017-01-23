package supermercadoOnline.web;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.unican.ps.supermercadoOnline.domain.Articulo;
import es.unican.ps.supermercadoOnline.utils.IRealizaPedidoRemote;

@Named ("supermercadoOnlineConfirmaCompraBean")
@SessionScoped
public class SupermercadoOnlineConfirmaCompraBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@EJB
	private IRealizaPedidoRemote remote2;
	
	@Inject
	private SupermercadoOnlineIniciaCompraBean bean;
	@Inject
	private SupermercadoOnlineTiendaWebBean bean2;

	//valores vinculados a los facelets
	private double precioUnitario;
	private String nombreArticulo;
	private Date date;
	

	//metodos de accion
	@PostConstruct
	public void init(){
		if(bean.getArticulo()!=null){
			nombreArticulo=bean.getArticulo().getNombre();
			precioUnitario=bean.getArticulo().getPrecio();
		}
			
		
	}
	public double getPrecioTotal(){
		double res =0;
		if(bean2.getCarro()!=null){
			//bucle que suma los precios
			List<Articulo> carro= bean2.getCarro();
			List<Integer> listaunidades=bean2.getUnidadesCarrito();
			for(int i=0;i<carro.size();i++){
				res+=carro.get(i).getPrecio()*listaunidades.get(i);
			}
		}
		return res;
	}
	
	public void logOut(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	public String goEnd(){
		remote2.confirmPedido(date);
		logOut();
		return "realizadaCompra.xhtml";
	}
	public String goBack(){

		return "iniciaCompra.xhtml";
	}
	public String goInit(){

		return "index.xhtml";
	}
	
	
	
	//Metodos observadores

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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public IRealizaPedidoRemote getRemote2() {
		return remote2;
	}
	
	
}
