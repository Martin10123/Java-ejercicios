package ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ventana extends JFrame {

    private JPanel panel;
    private JLabel saludo;
    private JTextField cajaTexto;
    private JButton boton;

    public Ventana() {
        setSize(500, 500); // Establecer tamaño de la ventana
        setTitle("Login"); // Establecemos el titulo en la ventana

        // setBounds(100, 200, 500, 500);
        // setLocation(100,200 ); // Establecemos posición inicial de la ventana
        setLocationRelativeTo(null);

        iniciarComponente();

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Deja de correr el programa automaticamente
    }

    private void iniciarComponente() {

        colocarPaneles();
        colocarAreasDeTexto();
        colocarBoton();
    }

    private void colocarPaneles() {
        panel = new JPanel(); // Creación de un panel

        // panel.setBackground(Color.GREEN); // Establecemos el color del panel
        panel.setLayout(null); // Desactivando el diseño
        this.getContentPane().add(panel); // Agregamos el panel a la ventana

    }

    private void colocarEtiqueta() {
        JLabel etiqueta = new JLabel("Ingrese su nombre:"); // creamos una etiqueta        
        etiqueta.setBounds(30, 10, 200, 30);
        etiqueta.setFont(new Font("cooper black", 30, 15));

        panel.add(etiqueta);
    }

    private void colocarCajasDeTexto() {
        cajaTexto = new JTextField();
        cajaTexto.setBounds(30, 50, 300, 30);

        panel.add(cajaTexto);
    }

    private void colocarAreasDeTexto() {
        JTextArea areaTexto = new JTextArea();
        areaTexto.setBounds(20, 20, 300, 300);
        areaTexto.setText("Escriba el texto aqui...");

        panel.add(areaTexto);
    }

    private void colocarBoton() {
        // Boton de texto
        boton = new JButton("Clikeame!!");
        boton.setBounds(150, 350, 150, 40);
        boton.setFont(new Font("arial", 0, 15));
        panel.add(boton);

    }
    
    private void eventoOyenteDeRaton() {
        
        MouseListener oyenteDeRaton = new MouseListener();
        
        boton.addMouseListener(oyenteDeRaton);
    }

    private void eventoOyenteAccion() {
        ActionListener oyenteDeAccion = (ActionEvent e) -> {
            saludo.setText("Hola " + cajaTexto.getText());
        };

        boton.addActionListener(oyenteDeAccion);
    }

    private void colocarRadioBotones() {
        JRadioButton radioBoton1 = new JRadioButton("Opción 1", true);
        radioBoton1.setBounds(50, 100, 100, 50);
        panel.add(radioBoton1);

        JRadioButton radioBoton2 = new JRadioButton("Opción 2", false);
        radioBoton2.setBounds(50, 150, 100, 50);
        panel.add(radioBoton2);

        JRadioButton radioBoton3 = new JRadioButton("Opción 3", false);
        radioBoton3.setBounds(50, 200, 100, 50);
        panel.add(radioBoton3);

        ButtonGroup grupoRadioBotones = new ButtonGroup();
        grupoRadioBotones.add(radioBoton1);
        grupoRadioBotones.add(radioBoton2);
        grupoRadioBotones.add(radioBoton3);
    }

    private void colocarListasDesplegables() {

        String[] paises = {"Peru", "Colombia", "Venezuela", "Argentina", "Brasil"};

        JComboBox listaDesplegable = new JComboBox(paises);
        listaDesplegable.setBounds(20, 20, 100, 30);

        listaDesplegable.addItem("Paraguay");
        listaDesplegable.setSelectedItem("Colombia");

        panel.add(listaDesplegable);
    }

}
