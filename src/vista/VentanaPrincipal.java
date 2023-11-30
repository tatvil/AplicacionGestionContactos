package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
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
	private JLabel etiqueta,titulo;

	public VentanaPrincipal(Agenda agenda) {
		this.agenda = agenda;
		definirParametros();
		definirColores();
		crearColumnas();
		crearBotones();
		initEventosVentanaPrincipal();
		setVisible(true);
	}

	private void definirColores() {
		Font font;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("antropof.ttf"));
			
			titulo = new JLabel("Mis contactos");
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			titulo.setFont(font.deriveFont(Font.BOLD, 30f));
			titulo.setBounds(200,5,285,30);
			titulo.setForeground(Color.WHITE);
			add(titulo);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void crearColumnas() {
		Object[][] datos = agenda.getContactos();
		String[] nombreColumnas = { "Nombre", "Telefono" };

		DefaultTableModel model = new DefaultTableModel(datos, nombreColumnas);
		lista = new JTable(model);

		lista.addMouseListener(new MouseAdapter() {
		});

		JScrollPane tablaContactos = new JScrollPane(lista);
		tablaContactos.setBounds(60, 50, 500, 400);
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
		getContentPane().setBackground(new Color(26,54,104)); 			// pone color al fondo de la pantalla
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
