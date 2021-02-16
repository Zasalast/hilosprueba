
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZASALAS
 */
public class Hilo1 implements  Runnable{
    
    DateTimeFormatter DFormate= DateTimeFormatter.ofPattern("hh:mm:ss a");
    private JLabel lb1,lb2;

    public Hilo1(JLabel lb1, JLabel lb2) {
        this.lb1 = lb1;
        this.lb2 = lb2;
        Thread hilo=new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        while (true) {            
            try {
                Thread.sleep(1000);
                lb1.setText(LocalDate.now()+"");
                lb2.setText(DFormate.format(LocalDateTime.now()));
            } catch (Exception e) {
            }
        }
}
    
    
}
