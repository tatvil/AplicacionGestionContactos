package controlador;

import java.util.ArrayList;

import modelo.Contactos;

public class Agenda {
	private ArrayList<Contactos> contactos;

	public Agenda() {
		crearAgenda();
	}

	private void crearAgenda() {
		contactos = new ArrayList<>();
		contactos.add(new Contactos("Alice", 932876159));
		contactos.add(new Contactos("Lucas", 933209845));
		contactos.add(new Contactos("Luis", 935139104));
	}

	public Object[][] getContactos() {
		Object[][] datos = new Object[contactos.size()][2];
		for (int i = 0; i < contactos.size(); i++) {
			datos[i][0] = contactos.get(i).getNombre();
			datos[i][1] = contactos.get(i).getTelefono();
		}
		return datos;
	}
	
	public void editarContacto(String nombre, int telefono) {
	    for (Contactos contacto : this.contactos) {
	        if (contacto.getNombre().equals(nombre)&& contacto.getTelefono()==(telefono)) {
	            contacto.setTelefono(telefono);
	            contacto.setNombre(nombre);
	            break;
	        }
	    }
	}
	

	public void setContactos(ArrayList<Contactos> contactos) {
		this.contactos = contactos;
	}

	public void addContacto(Contactos contacto) {
		contactos.add(contacto);
	}

	public void remove(Contactos contacto) {
		contactos.remove(contacto);

	}

}
