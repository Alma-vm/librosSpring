package almavm.libros1.mongo.documentos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Libros")
public class Libros {
	@Id
	private int id;
	private String nombre;
	private int precio;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Libros(int id, String nombre, int precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	
}
