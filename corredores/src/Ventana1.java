
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.green;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZASALAS
 */
public class Ventana1 extends JFrame implements ActionListener {

    JTextField Horas, Minutos, Segundos;
    JLabel fecha_JLabel, hora_JLabel;
    JPanel jp_center_panel, jp_controles, jp_centro, jp_izquierda, jp_derecha;
    JButton btn_iniciar, btn_pausar, btn_reiniciar, btn_parar, btn_iniciar_cuenta_delante, btn_pausar_cuenta_delante, btn_reiniciar_cuenta_delante, btn_parar_cuenta_delante;
    Temporizador Tempo;
    Fechaa fechass = new Fechaa();
    String fecha;
    String horaactual;
    JSlider silder1, silder2;
   Paneles panelsuperior = new Paneles();
    
    
    public Ventana1(int e) {   
   
    }  
    void panelsuperior(){
        panelsuperior.setBounds(0, 0, getWidth(), 80);add(panelsuperior); panelsuperior.setBackground(Color.black);
    }
    public Form(String title, int ancho, int alto, boolean bloqueo_ventana, boolean Visible_ventana) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout(2, 2));
        setSize(ancho + 10, alto + 40);//ancho , alto
        setBackground(Color.GRAY);///color fondo
        setLocationRelativeTo(null);//centro de pantallla
//        getContentPane().setBackground(Color.black);
        setResizable(bloqueo_ventana);//cambiar tamaño de pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CenterPanel();
        Components();
        ControlesPanelFlowLayout();
        panelCentro();
        PanelDerecha();
        PanelIzquierdo();

        jp_center_panel.add(jp_centro, BorderLayout.CENTER);
//        System.out.println(""+""+fechass.formateadr3.format(fechass.calendario.getTime()));;
//   String horaactual=""+fechass.formateadr.format(fechass.calendario.getTime());
        setVisible(Visible_ventana);
    }

    public void CenterPanel() {
        jp_center_panel = new JPanel();
        jp_center_panel.setLayout(new BorderLayout(5, 5));
        jp_center_panel.setBackground(Color.lightGray);

//jp_center_panel.add(jp_controles);
        jp_center_panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        this.add(jp_center_panel);
    }

    public void panelCentro() {

        Border jp_b_Centro;
        jp_b_Centro = BorderFactory.createLineBorder(Color.BLACK, 1);
//       
        jp_b_Centro = BorderFactory.createTitledBorder("Central");
        jp_centro = new JPanel();

        jp_centro.setLayout(new GridLayout(2, 0, 10, 10));
//        jp_controles.setBounds(x, y, alt, ancho);
        jp_centro.setBackground(Color.GRAY);

        jp_centro.setBorder(jp_b_Centro);

// jp_center_panel.add(jp_derecha, BorderLayout.EAST);
////        jp_centro.add(jp_derecha, BorderLayout.EAST);
//  jp_center_panel.add(jp_centro, BorderLayout.PAGE_START);
    }

    public void PanelDerecha() {
        Border jp_b_derecha;
        jp_b_derecha = BorderFactory.createLineBorder(Color.BLACK, 1);
//       
        jp_b_derecha = BorderFactory.createTitledBorder("Cuenta Atras");
        jp_derecha = new JPanel();

        jp_derecha.setLayout(new GridLayout(2, 0, 10, 10));
//        jp_controles.setBounds(x, y, alt, ancho);
        jp_derecha.setBackground(Color.GRAY);

        jp_derecha.setBorder(jp_b_derecha);

        jp_derecha.add(Minutos);
        jp_derecha.add(silder2); jp_derecha.add(btn_iniciar);
        jp_derecha.add(btn_pausar);
        jp_derecha.add(btn_reiniciar);
        jp_derecha.add(btn_parar);
        jp_centro.add(jp_derecha, BorderLayout.EAST);

    }

    public void PanelIzquierdo() {
        Border jp_b_izquierda;
        jp_b_izquierda = BorderFactory.createLineBorder(Color.BLACK, 1);
//       
        jp_b_izquierda = BorderFactory.createTitledBorder("Cuenta delante");
        jp_izquierda = new JPanel();

        jp_izquierda.setLayout(new GridLayout(2, 0, 10, 10));
//        jp_controles.setBounds(x, y, alt, ancho);
        jp_izquierda.setBackground(Color.GRAY);

        jp_izquierda.setBorder(jp_b_izquierda);

        jp_izquierda.add(Segundos);jp_izquierda.add(silder1);
        jp_izquierda.add(btn_iniciar_cuenta_delante);
        jp_izquierda.add(btn_pausar_cuenta_delante);
        jp_izquierda.add(btn_reiniciar_cuenta_delante);
        jp_izquierda.add(btn_parar_cuenta_delante);

        jp_centro.add(jp_izquierda, BorderLayout.WEST);
// jp_center_panel.add(jp_izquierda, BorderLayout.WEST);
//        jp_centro.add(jp_izquierda, BorderLayout.WEST);
    }

    public void ControlesPanelFlowLayout() {
        Border jp_b_Controles;
        jp_b_Controles = BorderFactory.createLineBorder(Color.BLACK, 1);
//       
        jp_b_Controles = BorderFactory.createTitledBorder("Controles");
        jp_controles = new JPanel();

        jp_controles.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 1));
//        jp_controles.setBounds(x, y, alt, ancho);
        jp_controles.setBackground(Color.GRAY);

        jp_controles.setBorder(jp_b_Controles);
        jp_controles.add(hora_JLabel);
        jp_controles.add(fecha_JLabel);

        jp_center_panel.add(jp_controles, BorderLayout.PAGE_END);
    }

    void Components() {
        JTextFieldsComponents();
        JButtonComponents();

        JLabelComponents();
        JSilderComponents();
    }

//    void JCalendarComponents() {
//        formateadr = new SimpleDateFormat("dd-MM-yyyy");
//        formateadr1 = new SimpleDateFormat("DD-MM-yyyy");
//        formateadr2 = new SimpleDateFormat("yyyy-MM-dd");
//        formateadr3 = new SimpleDateFormat("h:mm a");
//
//        jdc = new JCalendar();
//        jdc.setTodayButtonVisible(true);
//        jdc.setTodayButtonText("hot es");
//        calendario = new GregorianCalendar();
//        jdc.setDate(calendario.getTime());
//        jdc.setMaxSelectableDate(new Date());
//    }
    void JLabelComponents() {

        fecha_JLabel = new JLabel("");
        hora_JLabel = new JLabel(" ");
    }

    void JSilderComponents() {

        silder1 = new JSlider();
        silder1.setMinimum(1);
        silder1.setMaximum(4);
        silder1.setValue(0);
        silder1.setPaintTicks(true);
        silder1.setMajorTickSpacing(1);
        silder1.setPaintLabels(true);
        silder1.setBorder(BorderFactory.createTitledBorder("Velocidad"));
        silder2 = new JSlider();
        silder2.setMinimum(1);
        silder2.setMaximum(4);
        silder2.setValue(0);
        silder2.setPaintTicks(true);
        silder2.setMajorTickSpacing(1);
        silder2.setPaintLabels(true);
        silder2.setBorder(BorderFactory.createTitledBorder("Velocidad"));
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
        btn_reiniciar.addActionListener(this);

        btn_iniciar_cuenta_delante = new JButton("Iniciar");
        btn_iniciar_cuenta_delante.addActionListener(this);
        btn_pausar_cuenta_delante = new JButton("Pausa");
        btn_pausar_cuenta_delante.setEnabled(false);
        btn_pausar_cuenta_delante.addActionListener(this);
        btn_reiniciar_cuenta_delante = new JButton("Reiniciar");
        btn_reiniciar_cuenta_delante.setEnabled(false);
        btn_reiniciar_cuenta_delante.addActionListener(this);
        btn_parar_cuenta_delante = new JButton("Parar");
        btn_parar_cuenta_delante.setEnabled(false);
        btn_reiniciar_cuenta_delante.addActionListener(this);
    }

    void JTextFieldsComponents() {
        Border bt_horas;
        bt_horas = BorderFactory.createLineBorder(green, 1);
//       
        bt_horas = BorderFactory.createTitledBorder("Horas");
        Horas = new JTextField("0");
        Horas.setBorder(bt_horas);
//        Horas.setEditable(false);

        Border bt_minutos;
        bt_minutos = BorderFactory.createLineBorder(green, 1);
//       
        bt_minutos = BorderFactory.createTitledBorder("0-1000 Segundos");
        Minutos = new JTextField("0");
        Minutos.setBorder(bt_horas);
//        Minutos.setEditable(false);

        Border bt_segundos;
        bt_segundos = BorderFactory.createLineBorder(green, 1);
//       
        bt_minutos = BorderFactory.createTitledBorder("1000-0 Segundos");
        Segundos = new JTextField("1000");
        Segundos.setBorder(bt_horas);
//        Segundos.setEditable(false);
    }

    public Form(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

    public JTextField getHoras() {
        return Horas;
    }

    public void setHoras(JTextField Horas) {
        this.Horas = Horas;
    }

    public JTextField getMinutos() {
        return Minutos;
    }

    public void setMinutos(JTextField Minutos) {
        this.Minutos = Minutos;
    }

    public JTextField getSegundos() {
        return Segundos;
    }

    public void setSegundos(JTextField Segundos) {
        this.Segundos = Segundos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_iniciar) {
            Horas.setEditable(false);
            btn_iniciar.setEnabled(false);
            Minutos.setEditable(false);
            Segundos.setEditable(false);
            Tempo = new Temporizador(Integer.parseInt(Horas.getText()), Integer.parseInt(Minutos.getText()), Integer.parseInt(Segundos.getText()));

//  Tempo = new Temporizador(  Integer.parseInt(Segundos.getText()));
            Tempo.start();

        } else if (e.getSource() == btn_pausar) {
            Tempo.suspend();
        } else if (e.getSource() == btn_reiniciar) {
            Tempo.resume();
        } else if (e.getSource() == btn_parar) {
            Tempo.stop();
        }

//        else if (e.getSource() == btn_parar) {
//            Control_velocidad=(S1.getValue())*1000;
//        }
    }

    void horaActual(String text) {
        hora_JLabel.setText(text);
    }

}

        
 
 
