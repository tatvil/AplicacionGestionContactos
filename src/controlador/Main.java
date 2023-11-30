package controlador;

import vista.VentanaPrincipal;

public class Main {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		new VentanaPrincipal(agenda);
	}
}
