package es.unican.ps.supermercadoOnline.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Articulo {
	
	@Id
	private long id;
	private String nombre;
	private int unidadesStock;
	private double precio;
	private static long idCont=0;
	public Articulo(String nombre, int unidadesStock, double precio) {
		super();
		this.id = idCont++;
		this.nombre = nombre;
		this.unidadesStock = unidadesStock;
		this.precio = precio;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getUnidadesStock() {
		return unidadesStock;
	}
	public void setUnidadesStock(int unidadesStock) {
		this.unidadesStock = unidadesStock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
}
