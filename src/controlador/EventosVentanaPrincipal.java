package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Contactos;
import vista.VentanaAdministrador;

public class EventosVentanaPrincipal implements ActionListener {
	private JButton botonEditar;
	private JButton botonEliminar;
	private JTable lista;
	private JButton botonAgregarContacto;
	private Agenda agenda;

	public EventosVentanaPrincipal(JButton botonEditar, JButton botonEliminar, JTable lista,
			JButton botonAgregarContacto, Agenda agenda) {

		this.botonEditar = botonEditar;
		this.botonEliminar = botonEliminar;
		this.botonAgregarContacto = botonAgregarContacto;
		this.lista = lista;
		this.botonEditar.addActionListener(this);
		this.botonEliminar.addActionListener(this);
		this.botonAgregarContacto.addActionListener(this);
		this.agenda = agenda;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int fila = lista.getSelectedRow();
		String nombre = "";
		int telefono;
		if (fila != -1) {
			nombre = (String) lista.getValueAt(fila, 0);
			telefono = (int) lista.getValueAt(fila, 1);
			if (e.getSource() == botonEditar) {
				VentanaAdministrador ventanaAdministrador = new VentanaAdministrador(nombre, telefono, "editar", agenda,
						this, lista);
			} else if (e.getSource() == botonEliminar) {
				VentanaAdministrador ventanaAdministrador = new VentanaAdministrador(nombre, telefono, "eliminar",
						agenda, this, lista);
			}
		}
		if (e.getSource() == botonAgregarContacto) {
			VentanaAdministrador ventanaAdministrador = new VentanaAdministrador("", 0, "agregar", agenda, this, lista);
		}
	}

	public void actualizarTabla() {
		Object[][] datosActualizados = agenda.getContactos();
		String[] nombreColumnas = { "Nombre", "Telefono" };
		DefaultTableModel tablaActualizada = new DefaultTableModel(datosActualizados, nombreColumnas);
		lista.setModel(tablaActualizada);
		lista.repaint();
	}

}
