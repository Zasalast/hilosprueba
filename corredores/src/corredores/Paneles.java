/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corredores;

import java.awt.Color;
import java.awt.Font;
 
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ZASALAS
 */
public class Paneles extends JPanel {

    JLabel Chronos = new JLabel("00:00:00");

  

    Hiloscorredores HiloChrono = new Hiloscorredores(Chronos);

    public Jugador() {
        setLayout(null);
        setBackground(Color.GREEN);

        InChronos();

        add(Chronos);
        HiloChrono.start();
    }

    void InChronos() {
        Chronos.setFont(new Font("Traditional Arabic", Font.PLAIN, 30));
        Chronos.setBounds(607, 41, 237, 45);
        Chronos.setForeground(Color.red);
    }
}
