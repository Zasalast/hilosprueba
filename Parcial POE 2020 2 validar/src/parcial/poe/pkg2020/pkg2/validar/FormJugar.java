/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial.poe.pkg2020.pkg2.validar;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.green;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author ZASALAS
 */
public class FormJugar extends JFrame implements ActionListener, KeyListener {

    private String informe_estudiante = "";

    public String getInforme_estudiante() {
        return informe_estudiante;
    }

    public void setInforme_estudiante(String informe_estudiante) {
        this.informe_estudiante = informe_estudiante;
    }
    private Container contentPane;
    private String nombrearchivo = "";
    private OperacionArchivo guardar_log;
    private JLabel informe_JLabel, fecha_JLabel;
    private JButton btn_salir, btn_clear, btn_registrar;
    JTextField Casilla_JTextField;
    private JTextArea informe_estudiante_JTextArea, informe_JTextArea;
    Random random = new Random();
    private JScrollPane pane, pane_estudiante;
    JPanel jpMenu, jp_center_Segundario, jp_nombre_estudiante, jp_documento, jp_informe_notas, jp_cantidad, Imagen_JP, jp_center_panel, jp6, jp_controles;

    Fechas fecha;

    FormJugar(String Titulo, int ancho, int alto, boolean bloqueo_ventana, boolean Visible_ventana) {
        setTitle(Titulo);
        setLayout(new BorderLayout(5, 5));
        setSize(ancho + 10, alto + 40);//ancho , alto
        setBackground(Color.GRAY);///color fondo
        setLocationRelativeTo(null);//centro de pantallla
//        getContentPane().setBackground(Color.black);
        setResizable(bloqueo_ventana);//cambiar tamaño de pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        fecha = new Fechas();
        CenterPanelNotas(0, 0, 300, 100);
        Components();

//        PanelBuscar(0, 0, alto, ancho);
        CenterPanel(0, 0, ancho, alto);
        PanelMenu(0, 0, 200, 200);
        ControlesPanelFlowLayout(0, 0, 600, 80);
        Panel_Central_Segundario(0, 0, 300, 100);

        jp_center_panel.add(jp_center_Segundario, BorderLayout.CENTER);

        setVisible(Visible_ventana);
    }

    public void Panel_Central_Segundario(int x, int y, int alt, int ancho) {

        Imagen_JP = new JPanel();

        Imagen_JP.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        Imagen_JP.setBackground(Color.PINK);
        Imagen_JP.setLayout(new GridLayout(2, 3));

        Imagen_JP.add(fecha_JLabel);
        jp_center_Segundario.add(Imagen_JP);
    }

    public void CenterPanel(int x, int y, int alt, int ancho) {
        jp_center_panel = new JPanel();
        jp_center_panel.setLayout(new BorderLayout(5, 5));
        jp_center_panel.setBackground(Color.red);

//        jp_center_panel.setBounds(x, y, alt, ancho);
        jp_center_panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        this.add(jp_center_panel);
    }

    public void CenterPanelNotas(int x, int y, int alt, int ancho) {
        jp_center_Segundario = new JPanel();
        jp_center_Segundario.setLayout(new GridLayout(2, 2));
        jp_center_Segundario.setBackground(Color.PINK);

//        jp_center_notas.setBounds(x, y, alt, ancho);
        jp_center_Segundario.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
//       jp_center_Segundario.add(fecha_JLabel) ;

    }

    public void PanelMenu(int x, int y, int alt, int ancho) {
        Manejo(0, 0, 200, 200);
        Informe_errores(0, 0, 200, 200);
        jpMenu = new JPanel();
        jpMenu.setLayout(new BorderLayout());
//        jpMenu.setBounds(x, y, alt, ancho);
        jpMenu.setBackground(Color.black);
        jpMenu.setBorder(BorderFactory.createLineBorder(Color.black));
        jpMenu.add(jp_documento, BorderLayout.NORTH);
        jpMenu.add(jp_nombre_estudiante, BorderLayout.CENTER);
        jp_center_panel.add(jpMenu, BorderLayout.WEST);
    }

    public void Manejo(int x, int y, int alt, int ancho) {
        jp_documento = new JPanel();

        jp_documento.setLayout(new GridLayout(8, 0, 10, 10));
//        jp_documento.setBounds(x, y, alt, ancho);
        jp_documento.setBackground(Color.PINK);
        jp_documento.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jp_documento.add(informe_JLabel);
//        jp_documento.add(Casilla_JTextField);
        jp_center_panel.add(Casilla_JTextField, BorderLayout.PAGE_START);

    }

    public void Informe_errores(int x, int y, int alt, int ancho) {

        jp_nombre_estudiante = new JPanel();
        jp_nombre_estudiante.setLayout(new GridLayout(5, 0, 0, 0));

        jp_nombre_estudiante.setBackground(Color.PINK);
        jp_nombre_estudiante.setBorder(BorderFactory.createLineBorder(Color.black));

        jp_nombre_estudiante.add(pane);

    }

    public void ControlesPanelFlowLayout(int x, int y, int alt, int ancho) {

        jp_controles = new JPanel();
        jp_controles.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 1));
//        jp_controles.setBounds(x, y, alt, ancho);
        jp_controles.setBackground(Color.pink);
        jp_controles.setBorder(BorderFactory.createLineBorder(Color.black));

        jp_controles.add(btn_registrar);

        jp_controles.add(btn_salir);

        jp_center_panel.add(jp_controles, BorderLayout.PAGE_END);
    }

    void JTextAreaComponents() {

        pane = new JScrollPane(informe_JTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    void JTextFieldComponents() {

        Border bt_primer_nombre;
        bt_primer_nombre = BorderFactory.createLineBorder(green, 1);
        bt_primer_nombre = BorderFactory.createTitledBorder(bt_primer_nombre, "Primer nombre");
        bt_primer_nombre = BorderFactory.createTitledBorder("Casilla");

        Casilla_JTextField = new JTextField();
        Casilla_JTextField.setBorder(bt_primer_nombre);
        Casilla_JTextField.setText("");
        Casilla_JTextField.setEditable(true);
        Casilla_JTextField.addKeyListener(this);

    }
    EscalarImagenLabel scale_imagen;

    void JLabelComponents() {
        scale_imagen = new EscalarImagenLabel();

        fecha_JLabel = new JLabel();
        fecha_JLabel.setBounds(0, 0, 800, 800);
        fecha_JLabel.setIcon(scale_imagen.PonerLaImagen("\\ajedrez.PNG", fecha_JLabel));
        informe_JLabel = new JLabel("Informe Juego");

    }

    void JButtonComponents() {
        btn_registrar = new JButton("Registrar");
        btn_registrar.setBounds(50, 150, 200, 30);
        btn_registrar.addActionListener(this);

        btn_salir = new JButton("Salir");

        btn_salir.setBounds(10, 200, 200, 200);
        btn_salir.addActionListener(this);

    }

    void Components() {

        JButtonComponents();
        JTextFieldComponents();
        JTextAreaComponents();

        JLabelComponents();
    }

    void validar() {
        if (Casilla_JTextField.getText().trim().length() == 2) {
            String letra_0 = "" + Casilla_JTextField.getText().charAt(0);
            String letra_1 = "" + Casilla_JTextField.getText().charAt(0);
            try {
                int numero = 0;
                numero = Integer.parseInt(letra_1);

                if (numero >= 1 && numero <= 8) {
                    if (letra_0.equals("a") || "A".equals(letra_0)) {
                        System.out.println("entro a");
                        if (Integer.parseInt(letra_1) % 2 == 0) {
                            informe_JTextArea.setText("Es BLANCA");
                        } else {
                            informe_JTextArea.setText("Es Negra");
                        }
                    }

                    if (letra_0 == "b" || "B".equals(letra_0)) {
                        System.out.println("entro b");
                        if (Integer.parseInt(letra_1) % 2 == 0) {
                            informe_JTextArea.setText("Es Negra");
                        } else {
                            informe_JTextArea.setText("Es Blanca");
                        }
                    }
                    if (letra_0 == "c" || "C".equals(letra_0)) {
                        System.out.println("entro c");
                        if (Integer.parseInt(letra_1) % 2 == 0) {
                            informe_JTextArea.setText("Es BLANCA");
                        } else {
                            informe_JTextArea.setText("Es Negra");
                        }
                    }
                    if (letra_0 == "d" || "D".equals(letra_0)) {
                        System.out.println("entro d");
                        if (Integer.parseInt(letra_1) % 2 == 0) {
                            informe_JTextArea.setText("Es Negra");
                        } else {
                            informe_JTextArea.setText("Es Blanca");
                        }
                    }
                    if (letra_0 == "e" || "E".equals(letra_0)) {
                        System.out.println("entro e");
                        if (Integer.parseInt(letra_1) % 2 == 0) {
                            informe_JTextArea.setText("Es BLANCA");
                        } else {
                            informe_JTextArea.setText("Es Negra");
                        }
                    }
                    if (letra_0 == "f" || "F".equals(letra_0)) {
                        System.out.println("entro f");
                        if (Integer.parseInt(letra_1) % 2 == 0) {
                            informe_JTextArea.setText("Es Negra");
                        } else {
                            informe_JTextArea.setText("Es Blanca");
                        }
                    }
                    if (letra_0 == "g" || "G".equals(letra_0)) {
                        System.out.println("entro g");
                        if (Integer.parseInt(letra_1) % 2 == 0) {
                            informe_JTextArea.setText("Es BLANCA");
                        } else {
                            informe_JTextArea.setText("Es Negra");
                        }
                    }
                    if (letra_0 == "h" || "H".equals(letra_0)) {
                        System.out.println("entro h");
                        if (Integer.parseInt(letra_1) % 2 == 0) {
                            informe_JTextArea.setText("Es Negra");
                        } else {
                            informe_JTextArea.setText("Es Blanca");
                        }
                    }
                    System.out.println(letra_0);
                    System.out.println(letra_1);
                    System.out.println("no entro");
                }
            } catch (Exception e10) {
                System.out.println("error: " + e10.getMessage());
                try {
                    String mens = "" + e10.getMessage();

                    nombrearchivo = "ErrorLog" + "";

                    guardar_log.crear_archivo_plano(nombrearchivo, mens);
                } catch (IOException ex) {

                }
            }

        } else {

            System.out.println("error: " + "longitud incorecta");
            try {
                String mens = "" + "longitud incorecta";

                nombrearchivo = "ErrorLog" + "";

                guardar_log.crear_archivo_plano(nombrearchivo, mens);
            } catch (IOException ex) {
            }
        }

//            System.out.println(""+Casilla_JTextField.getText().length());
//             String txt=  "adasd";
//             System.out.println(""+txt.length());
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_registrar) {
            validar();
        } else if (e.getSource() == btn_clear) {

            Casilla_JTextField.setText("");

        } else if (e.getSource() == btn_salir) {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
////  
        System.out.println("keyTyped");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("PRESIONAR");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

}
