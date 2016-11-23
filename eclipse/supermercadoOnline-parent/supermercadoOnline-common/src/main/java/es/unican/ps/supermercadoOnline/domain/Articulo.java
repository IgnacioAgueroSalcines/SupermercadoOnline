package es.unican.ps.supermercadoOnline.domain;

public class Articulo {
	
	private long id;
	private String nombre;
	private int unidadesStock;
	private double precio;
	public Articulo(long id, String nombre, int unidadesStock, double precio) {
		super();
		this.id = id;
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
