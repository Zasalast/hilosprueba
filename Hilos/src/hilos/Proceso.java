/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZASALAS
 */
public class Proceso extends Thread{
    String mensaje;
    public Proceso(String msn){
        super(msn);
    }
    public void run(){
        for (int i = 0; i < 15; i++) {
            System.out.println(mensaje);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Este proceso ha terminado: "+ this.getName());
    }
    public  void setMensaje(String msn){
        this.mensaje=msn;
    }
    
}
