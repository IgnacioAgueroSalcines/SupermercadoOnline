package es.unican.ps.supermercadoOnline.domain;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	private long id;
	


	private String nombre;
	private String dni;
	private String direccion;
	
	
	public String getNombre() {
		return nombre;
	}
	
	public Usuario(){}
	
	public Usuario(long id, String nombre, String dni, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Usuario(String nombre, String dni, String direccion) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
	}

}
