/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial.poe.pkg2020.pkg2.validar;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.green;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ZASALAS
 */
public class FormValidarJugar extends JFrame implements ActionListener {

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

    private JTextArea informe_estudiante_JTextArea, informe_JTextArea;
    Random random = new Random();
    private JScrollPane pane, pane_estudiante;
    JPanel jpMenu, jp_center_notas, jp_nombre_estudiante, jp_documento, jp_informe_notas, jp_cantidad, jp_iingreso_notas, jp_center_panel, jp6, jp_controles;
    JTextField jtf1, jtf2, primer_nombre_JTextField;
    MaskFormatter jf1, jf2, jf3, jf4, jf5;
    Fechas fecha;

    FormValidarJugar(String Titulo, int ancho, int alto, boolean bloqueo_ventana, boolean Visible_ventana) {
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

        CenterPanel(0, 0, ancho, alto);

        ControlesPanelFlowLayout(0, 0, 600, 80);
        Panel_Informe(0, 0, 300, 100);

        jp_center_panel.add(jp_center_notas, BorderLayout.CENTER);

        setVisible(Visible_ventana);
    }

    public void Panel_Informe(int x, int y, int alt, int ancho) {

        jp_iingreso_notas = new JPanel();

        jp_iingreso_notas.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jp_iingreso_notas.setBackground(Color.PINK);
        jp_iingreso_notas.setLayout(new GridLayout(1, 3));
        optenerCalendario();
        jp_iingreso_notas.add(fecha_JLabel);
        jp_iingreso_notas.add(jdc);
        jp_iingreso_notas.add(informe_JLabel);
        jp_iingreso_notas.add(pane);
        jp_center_notas.add(jp_iingreso_notas);
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
        jp_center_notas = new JPanel();
        jp_center_notas.setLayout(new GridLayout(2, 2));
        jp_center_notas.setBackground(Color.PINK);

//        jp_center_notas.setBounds(x, y, alt, ancho);
        jp_center_notas.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

    }

//    public void PanelMenu(int x, int y, int alt, int ancho) {
//        DocumentoEstudiantesPanelFlowLayout(0, 0, 200, 200);
////        NombreEstudiantePanelFlowLayout(0, 0, 200, 200);
//        jpMenu = new JPanel();
//        jpMenu.setLayout(new BorderLayout());
////        jpMenu.setBounds(x, y, alt, ancho);
//        jpMenu.setBackground(Color.black);
//        jpMenu.setBorder(BorderFactory.createLineBorder(Color.black));
//        jpMenu.add(jp_documento, BorderLayout.NORTH);
////        jpMenu.add(jp_nombre_estudiante, BorderLayout.CENTER);
//        jp_center_panel.add(jpMenu, BorderLayout.WEST);
//    }
    public void DocumentoEstudiantesPanelFlowLayout(int x, int y, int alt, int ancho) {
        jp_documento = new JPanel();

        jp_documento.setLayout(new GridLayout(8, 0, 10, 10));
//        jp_documento.setBounds(x, y, alt, ancho);
        jp_documento.setBackground(Color.PINK);
        jp_documento.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jp_documento.add(informe_JLabel);
        jp_documento.add(pane);

    }

    JCalendar jdc;
    private JDateChooser jDateChooser1;
    Calendar calendario;

    public void optenerCalendario() {
        jdc = new JCalendar();
        jdc.setTodayButtonVisible(true);
        jdc.setTodayButtonText("hoy es");
        calendario = new GregorianCalendar();
        jdc.setDate(calendario.getTime());
        jdc.setMaxSelectableDate(new Date());

    }

//    public void NombreEstudiantePanelFlowLayout(int x, int y, int alt, int ancho) {
//
//        jp_nombre_estudiante = new JPanel();
//        jp_nombre_estudiante.setLayout(new GridLayout(5, 0, 0, 0));
//
//        jp_nombre_estudiante.setBackground(Color.PINK);
//        jp_nombre_estudiante.setBorder(BorderFactory.createLineBorder(Color.black));
//
//        
//        jp_nombre_estudiante.add(pane);
////        jp_nombre_estudiante.add(primer_nombre_JTextField);
//
//    }
    public void DatosPersonalesPanelGridLayout(int x, int y, int alt, int ancho) {

        jp_informe_notas = new JPanel();
        jp_informe_notas.setLayout(new GridLayout(3, 3, 0, 0));

        jp_informe_notas.setBackground(Color.PINK);
        jp_informe_notas.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        jp_center_notas.add(jp_informe_notas);
    }

    public void ControlesPanelFlowLayout(int x, int y, int alt, int ancho) {

        jp_controles = new JPanel();
        jp_controles.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 1));
//        jp_controles.setBounds(x, y, alt, ancho);
        jp_controles.setBackground(Color.pink);
        jp_controles.setBorder(BorderFactory.createLineBorder(Color.black));

        jp_controles.add(btn_registrar);

        jp_controles.add(btn_salir);
        jp_center_panel.add(primer_nombre_JTextField, BorderLayout.PAGE_START);
        jp_center_panel.add(jp_controles, BorderLayout.PAGE_END);
    }

    void JTextAreaComponents() {

        informe_JTextArea = new JTextArea();

        informe_JTextArea.setLineWrap(true);

        informe_JTextArea.setEditable(false);
        informe_JTextArea.setBounds(10, 5, 100, 100);
        pane = new JScrollPane(informe_JTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    public void formato() {
        try {

            jf2 = new MaskFormatter("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");//nota

        } catch (Exception e) {
            System.out.println("Formato no valido");
        }
    }

    void JTextFieldComponents() {
        formato();

        Border bt_primer_nombre;
        bt_primer_nombre = BorderFactory.createLineBorder(green, 1);
//       
        bt_primer_nombre = BorderFactory.createTitledBorder("Nombre");
        primer_nombre_JTextField = new JTextField();
        primer_nombre_JTextField.setBorder(bt_primer_nombre);
        primer_nombre_JTextField.setText("");
//        primer_nombre_JTextField.setEditable(true);

    }

    void JLabelComponents() {

        fecha_JLabel = new JLabel("Ingrese Fecha nacimiento");
        informe_JLabel = new JLabel("Informe Validación");

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
    SimpleDateFormat formateadr = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_registrar) {

            if (primer_nombre_JTextField.getText().trim().length() % 2 == 0) {
                if (primer_nombre_JTextField.getText().trim().length() >= 2) {
                    System.out.println("no puede ingresar");
                    if ((jdc.getDate().getMonth() + 1) == (calendario.getTime().getMonth())) {
                       FormJugar formulario;
            formulario = new FormJugar("Parcial 2 Poe 2020 2", 1250, 650, false, true); 
            this.dispose();
                        System.out.println("meses iguales");
                    } else {
                        System.out.println("meses distintos");
                    }
                    System.out.println("" + formateadr.format(calendario.getTime()));
                    System.out.println("cumple" + (jdc.getDate().getMonth() + 1));
                    System.out.println("actual" + (calendario.getTime().getMonth()+1));
                    ;

                } else {
                    System.out.println(" Nombre muy corto");
                }
            } else {
                System.out.println(" inpar");
            }

        } else if (e.getSource() == btn_clear) {

            primer_nombre_JTextField.setText("");

        } else if (e.getSource() == btn_salir) {
            System.exit(0);
        }
    }

}
