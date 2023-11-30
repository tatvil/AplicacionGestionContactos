package modelo;

import java.util.ArrayList;

public class Contactos {

	String nombre;
	int telefono;
	ArrayList<Contactos> listaContactos;

	public Contactos(String nombre, int telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Contactos() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
