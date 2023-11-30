package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.Agenda;
import controlador.EventosVentanaAdministrador;
import controlador.EventosVentanaPrincipal;

public class VentanaAdministrador extends JFrame {

    private JTextField cajaTextoNombre;
    private JTextField cajaTextoTelefono;
    private JButton botonOk;
    private JButton botonCancel; 
    private Agenda agenda;
    private String accion;
    private EventosVentanaPrincipal tabla;
    private JTable lista; 

    public VentanaAdministrador(String nombre, int telefono, String accion, Agenda agenda, EventosVentanaPrincipal tabla, JTable lista) { 
        this.accion = accion;
        this.agenda = agenda;
        this.tabla = tabla;
        this.lista = lista; 
        cajaTextoNombre = new JTextField(nombre);
        cajaTextoTelefono = new JTextField(String.valueOf(telefono));
        definirParametros();
        crearBotones();
        initEventosVentanaAdministrador();
        setVisible(true);
    }

    private void crearBotones() {
        botonOk = new JButton("Ok");
        botonOk.setBounds(50, 110, 60, 30);
        this.add(botonOk);

        botonCancel = new JButton("Cancel"); 
        botonCancel.setBounds(120, 110, 90, 30);
        this.add(botonCancel);
    }

    private void definirParametros() {
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        JLabel etiquetaNombre = new JLabel("Nombre");
        etiquetaNombre.setBounds(50, 30, 100, 30);
        this.add(etiquetaNombre);
        cajaTextoNombre.setBounds(150, 30, 100, 30);
        this.add(cajaTextoNombre);

        JLabel etiquetaTelefono = new JLabel("Telefono");
        etiquetaTelefono.setBounds(50, 70, 100, 30);
        this.add(etiquetaTelefono);
        cajaTextoTelefono.setBounds(150, 70, 100, 30);
        this.add(cajaTextoTelefono);
    }

    public void initEventosVentanaAdministrador() {
        EventosVentanaAdministrador eventos = new EventosVentanaAdministrador(cajaTextoNombre, cajaTextoTelefono, botonOk, botonCancel, accion, agenda, tabla, lista);
        botonOk.addActionListener(eventos);
        botonCancel.addActionListener(eventos);
    }

    public void ventanaAdministador() {
        
    }
}
