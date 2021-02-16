/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreracontadores;

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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;

/**
 *
 * @author ZASALAS
 */
public class VentanaPrincipal  extends JFrame implements ActionListener, KeyListener {

    private String informe_estudiante = "";

    public String getInforme_estudiante() {
        return informe_estudiante;
    }

    public void setInforme_estudiante(String informe_estudiante) {
        this.informe_estudiante = informe_estudiante;
    }
    private Container contentPane;
    private String nombrearchivo = "";
//    private Guardar_Log guardar_log;
    private JLabel informe_JLabel, fecha_JLabel;
    private JButton btn_salir, btn_clear, btn_registrar,btn_iniciar,btn_pausar,btn_reiniciar,btn_parar;
    JTextField Casilla1_JTextField,Casilla2_JTextField,Casilla3_JTextField,Casilla4_JTextField,ingresar_rango_JTextField;
    private JTextArea informe_estudiante_JTextArea, informe_JTextArea;
    Random random = new Random();
    private JScrollPane pane, pane_estudiante;
    JPanel jpMenu, jp_center_Segundario, jp_nombre_estudiante, jp_documento, jp_informe_notas, jp_cantidad, Imagen_JP, jp_center_panel, jp6, jp_controles;

    Tiempo fecha;

    VentanaPrincipal(String Titulo, int ancho, int alto, boolean bloqueo_ventana, boolean Visible_ventana) {
        setTitle(Titulo);
        setLayout(new BorderLayout(5, 5));
        setSize(ancho + 10, alto + 40);//ancho , alto
        setBackground(Color.GRAY);///color fondo
        setLocationRelativeTo(null);//centro de pantallla
//        getContentPane().setBackground(Color.black);
        setResizable(bloqueo_ventana);//cambiar tamaño de pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        fecha = new Tiempo();
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

//        Imagen_JP.add( );
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
        jp_documento.add(Casilla1_JTextField);
         jp_documento.add(Casilla2_JTextField);
          jp_documento.add(Casilla3_JTextField);
           jp_documento.add(Casilla4_JTextField);
           
        jp_center_panel.add(ingresar_rango_JTextField, BorderLayout.PAGE_START);
 jp_center_panel.add(pane,BorderLayout.CENTER);
    }

    public void Informe_errores(int x, int y, int alt, int ancho) {

        jp_nombre_estudiante = new JPanel();
        jp_nombre_estudiante.setLayout(new GridLayout(5, 0, 0, 0));

        jp_nombre_estudiante.setBackground(Color.PINK);
        jp_nombre_estudiante.setBorder(BorderFactory.createLineBorder(Color.black));

       

    }

    public void ControlesPanelFlowLayout(int x, int y, int alt, int ancho) {

        jp_controles = new JPanel();
        jp_controles.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 1));
//        jp_controles.setBounds(x, y, alt, ancho);
        jp_controles.setBackground(Color.pink);
        jp_controles.setBorder(BorderFactory.createLineBorder(Color.black));

        
        jp_controles.add(btn_iniciar);
         jp_controles.add(btn_pausar);
          jp_controles.add(btn_reiniciar);
   jp_controles.add(btn_parar);
        jp_controles.add(btn_registrar);

        jp_controles.add(btn_salir);

        jp_center_panel.add(jp_controles, BorderLayout.PAGE_END);
    }

    void JTextAreaComponents() {

        pane = new JScrollPane(informe_JTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    void JTextFieldComponents() {

        Border bt_Casilla1;
        bt_Casilla1 = BorderFactory.createLineBorder(green, 1);        
        bt_Casilla1 = BorderFactory.createTitledBorder("Casilla 1");
        
        Border bt_Casilla2;
        bt_Casilla2 = BorderFactory.createLineBorder(green, 1);        
        bt_Casilla2 = BorderFactory.createTitledBorder("Casilla 2");
        
        Border bt_Casilla3;
        bt_Casilla3 = BorderFactory.createLineBorder(green, 1);        
        bt_Casilla3 = BorderFactory.createTitledBorder("Casilla 3");
        
        Border bt_Casilla4;
        bt_Casilla4 = BorderFactory.createLineBorder(green, 1);        
        bt_Casilla4 = BorderFactory.createTitledBorder("Casilla 4");
        
        Border bt_ingresar_rango;
        bt_ingresar_rango = BorderFactory.createLineBorder(green, 1);        
        bt_ingresar_rango = BorderFactory.createTitledBorder("Ingresar Rango");
        
    
        
        

        Casilla1_JTextField = new JTextField();
        Casilla1_JTextField.setBorder(bt_Casilla1);
        Casilla1_JTextField.setText("");
        Casilla1_JTextField.setEditable(true);
        Casilla1_JTextField.addKeyListener(this);
        
         Casilla2_JTextField = new JTextField();
        Casilla2_JTextField.setBorder(bt_Casilla2);
        Casilla2_JTextField.setText("");
        Casilla2_JTextField.setEditable(true);
        Casilla2_JTextField.addKeyListener(this);
        
         Casilla3_JTextField = new JTextField();
        Casilla3_JTextField.setBorder(bt_Casilla3);
        Casilla3_JTextField.setText("");
        Casilla3_JTextField.setEditable(true);
        Casilla3_JTextField.addKeyListener(this);
        
         Casilla4_JTextField = new JTextField();
        Casilla4_JTextField.setBorder(bt_Casilla4);
        Casilla4_JTextField.setText("");
        Casilla4_JTextField.setEditable(true);
        Casilla4_JTextField.addKeyListener(this);
        
        ingresar_rango_JTextField  = new JTextField();
        ingresar_rango_JTextField.setBorder(bt_ingresar_rango);
        ingresar_rango_JTextField.setText("");
        ingresar_rango_JTextField.setEditable(true);
        ingresar_rango_JTextField.addKeyListener(this);

    }
 

    void JLabelComponents() {
        informe_JLabel = new JLabel("Informe Juego");

    }

    void JButtonComponents() {
           btn_iniciar = new JButton("Iniciar");
        btn_iniciar.setEnabled(true);
        btn_iniciar.addActionListener(this);
        btn_pausar = new JButton("Pausa");
        btn_pausar.setEnabled(false);
        btn_pausar.addActionListener(this);
        btn_reiniciar = new JButton("Reiniciar");
        btn_reiniciar.setEnabled(false);
        btn_reiniciar.addActionListener(this);
        btn_parar = new JButton("Parar");
        btn_parar.setEnabled(false);
        btn_parar.addActionListener(this);
        
        
        
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
        System.out.println("");
//        if () {
//            
//            try {
//               
//            } catch (Exception e10) {
//                System.out.println("error: " + e10.getMessage());
//                try {
//                    String mens = "" + e10.getMessage();
//
//                    nombrearchivo = "ErrorLog" + "";
//
//                    guardar_log.crear_archivo_plano(nombrearchivo, mens);
//                } catch (IOException ex) {
//
//                }
//            }
//
//        } else {
//
//            System.out.println("error: " + "longitud incorecta");
//            try {
//                String mens = "" + "longitud incorecta";
//
//                nombrearchivo = "ErrorLog" + "";
//
//                guardar_log.crear_archivo_plano(nombrearchivo, mens);
//            } catch (IOException ex) {
//            }
//        }

//            System.out.println(""+Casilla_JTextField.getText().length());
//             String txt=  "adasd";
//             System.out.println(""+txt.length());
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_registrar) {
            validar();
        } else if (e.getSource() == btn_clear) {

            Casilla1_JTextField.setText("");

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

