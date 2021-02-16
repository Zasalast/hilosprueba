/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corredores;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author ZASALAS
 */
public class Hiloscorredores extends Thread {

    int Hora = 0, Segundo = 0, Minuto = 0;
    JLabel Chronos;
//    Jugador J;

    public hilo(JLabel crono) {
        this.Chronos = crono;

    }

    void InChronos() {
        Chronos.setFont(new Font("Traditional Arabic", Font.PLAIN, 30));
        Chronos.setBounds(47, 11, 137, 45);
//        Chronos.setText("" + hora + ":" + minuto + ":" + segundo+" no");
        Chronos.setForeground(Color.red);
    }

    public void run() {

        try {
            int x = 0;
            System.out.println("1");
            while (true) {
                Segundo++;
                System.out.println("2");

                Thread.sleep(1000);
                System.out.println("3");
                ejecutarhilo();
                System.out.println("4");
                x++;
                System.out.println("5");
            }

        } catch (Exception e) {
            System.out.println("exception en el hilo : " + e.getMessage());
        }
    }

    private void ejecutarhilo() {
        System.out.println("7");
        setSegundo(getSegundo() + 1);
        System.out.println("8");
        if (getSegundo() > 59) {
            System.out.println("9");
            setSegundo(0);
            setMinuto(getMinuto() + 1);
            if (getMinuto() > 59) {
                setMinuto(0);
                setHora(getHora() + 1);
            }
        }
        String Seg = "", Min = "", Hora = "";
        if (getSegundo() < 10) {
            Seg = "0" + getSegundo();

        } else {
            Seg = "" + getSegundo();

        }
        if (getMinuto() < 10) {
            Min = "0" + getMinuto();

        } else {
            Min = "" + getMinuto();

        }
        if (getHora() < 10) {
            Hora = "0" + getHora();

        } else {
            Hora = "" + getHora();
        }

//        TextSeg+=ventana.segundo;
//        TextMin+=ventana.minuto;
//        TextHora+=ventana.hora;
        String reloj = getHora() + ":" + getMinuto() + ":" + getSegundo();
        Chronos.setText(reloj);
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int Hora) {
        this.Hora = Hora;
    }

    public int getSegundo() {
        return Segundo;
    }

    public void setSegundo(int Segundo) {
        this.Segundo = Segundo;
    }

    public int getMinuto() {
        return Minuto;
    }

    public void setMinuto(int Minuto) {
        this.Minuto = Minuto;
    }

    public JLabel getChronos() {
        return Chronos;
    }

    public void setChronos(JLabel Chronos) {
        this.Chronos = Chronos;
    }
