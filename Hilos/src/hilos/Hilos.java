/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author ZASALAS
 */
public class Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Proceso hilo1 = new Proceso("h1");
        Proceso hilo2 = new Proceso("h2");
        hilo1.setMensaje("msn 1 ");
        hilo2.setMensaje("msn 2 ");

        hilo1.start();
        hilo2.start();

    }

}
