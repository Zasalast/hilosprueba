
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ZASALAS
 */
public class Temporizador extends Thread {

    JTextField Minutos, Segundos;
    int hora, minutos, segundos, velocidad;
    Form ventana;
    Fechaa fechass;

    public Temporizador(int hora, int munutos, int segundos) {
        this.hora = hora = 0;
        this.minutos = munutos = 0;
        this.segundos = segundos = 0;
    }

    public Temporizador(JTextField Minutos, JTextField Segundos) {

        this.Minutos = Minutos;
        this.Segundos = Segundos;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void run() {

        super.run();
        while (true) {
            tiempoatras();
            try {

                ventana.Horas.setText("" + getHora());
                Minutos.setText("" + getMinutos());
                Segundos.setText("" + getSegundos());
//                ventana.horaActual(text);
                System.out.println(" " + getHora() + " : " + getMinutos() + " : " + getSegundos());
                Thread.sleep(1000         );
//To change body of generated methods, choose Tools | Templates.
            } catch (InterruptedException ex) {
                Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    String visualizar() {
        return null;
    }

    void tiempoatras() {

        if (getSegundos() > 0) {
            setSegundos(getSegundos() - 1);
        } else {
            setSegundos(59);
            if (getMinutos() > 0) {
                setMinutos(getMinutos() - 1);
            } else {
                setMinutos(59);
                if (getHora() > 0) {
                    setHora(getHora() - 1);
                }
                // si segundo = 0, minuto = 0 y hora = 0,
                // cancelamos el timer

            }
        }

    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

}
