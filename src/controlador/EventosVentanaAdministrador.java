package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import modelo.Contactos;
import vista.VentanaPrincipal;

public class EventosVentanaAdministrador implements ActionListener {
	private JTextField cajaTextoNombre, cajaTextoTelefono;
	private JButton botonOk;
	private String accion;
	private Agenda agenda;
	private EventosVentanaPrincipal tabla;
	private JTable lista;
	private JButton botonCancel;

	public EventosVentanaAdministrador(JTextField cajaTextoNombre, JTextField cajaTextoTelefono, JButton botonOk,
			JButton botonCancel, String accion, Agenda agenda, EventosVentanaPrincipal tabla, JTable lista) {

		this.cajaTextoNombre = cajaTextoNombre;
		this.cajaTextoTelefono = cajaTextoTelefono;
		this.botonOk = botonOk;
		this.accion = accion;
		this.agenda = agenda;
		this.tabla = tabla;
		this.lista = lista;
		this.botonCancel = botonCancel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = cajaTextoNombre.getText();
		try {
			int telefono = Integer.parseInt(cajaTextoTelefono.getText());
			if (nombre == null || nombre.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error! El campo no puede estar vacio un nombre valido", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			Contactos contactos = new Contactos(nombre, telefono);
			DefaultTableModel model = (DefaultTableModel) lista.getModel();
			if (e.getSource() == botonOk) {
				if (accion.equals("editar")) {
					agenda.editarContacto(nombre, telefono);
					int columna = lista.getSelectedRow();
					if (columna != -1) {
						model.setValueAt(nombre, columna, 0);
						model.setValueAt(telefono, columna, 1);
					}
				} else if (accion.equals("eliminar")) {
					agenda.remove(contactos);
					int fila = lista.getSelectedRow();
					if (fila != -1) {
						model.removeRow(fila);
					}
				} else if (accion.equals("agregar")) {
					agenda.addContacto(contactos);
					model.addRow(new Object[] { nombre, telefono });
				}
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Error! Introduce un numero de telefono valido", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		if (e.getSource() == botonOk || e.getSource() == botonCancel) {
			((JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource())).dispose();
		}
	}

}
