/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZASALAS
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HiloRunnabe hilo2= new HiloRunnabe(" Nombre 1 ");
        Thread hilo1= new Thread(hilo2);
    hilo1.start();
    
    
    
        HiloRunnabe h2= new HiloRunnabe(" Nombre 2 ");
        Thread h = new Thread(h2);
    h.start();
    }
    
}
