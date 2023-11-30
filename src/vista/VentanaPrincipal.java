package vista;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Agenda;
import controlador.EventosVentanaAdministrador;
import controlador.EventosVentanaPrincipal;

public class VentanaPrincipal extends JFrame {
	private Agenda agenda;
	private JTable lista;
	private JButton botonEliminar;
	private JButton botonEditar;
	private JButton botonAgregarContacto;
	private JLabel etiqueta;

	public VentanaPrincipal(Agenda agenda) {
		this.agenda = agenda;
		definirParametros();
		crearColumnas();
		crearBotones();
		initEventosVentanaPrincipal();
		setVisible(true);
	}

	private void crearColumnas() {
		Object[][] datos = agenda.getContactos();
		String[] nombreColumnas = { "Nombre", "Telefono" };

		DefaultTableModel model = new DefaultTableModel(datos, nombreColumnas);
		lista = new JTable(model);

		lista.addMouseListener(new MouseAdapter() {
		});

		JScrollPane tablaContactos = new JScrollPane(lista);
		tablaContactos.setBounds(50, 50, 500, 400);
		add(tablaContactos);

	}

	private void crearBotones() {
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(600, 120, 90, 30);
		add(botonEliminar);

		botonEditar = new JButton("Editar");
		botonEditar.setBounds(600, 220, 90, 30);
		add(botonEditar);

		botonAgregarContacto = new JButton("Añadir contacto");
		botonAgregarContacto.setBounds(255, 470, 150, 30);
		add(botonAgregarContacto);

	}

	private void definirParametros() {
		setTitle("Mis Contactos");
		setIconImage(Toolkit.getDefaultToolkit().getImage("agenda.png"));
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		etiqueta = new JLabel(new ImageIcon("agenda.png"));
		add(etiqueta);

	}

	public void initEventosVentanaPrincipal() {
		new EventosVentanaPrincipal(botonEditar, botonEliminar, lista, botonAgregarContacto, agenda);

	}

	public JTable getLista() {
		return lista;
	}

	public void setLista(JTable lista) {
		this.lista = lista;
	}

}
