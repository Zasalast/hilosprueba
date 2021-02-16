/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author ZASALAS
 */
public class Verificarcuenta implements Runnable{
    private Cuenta cb=new Cuenta();
    private synchronized void HacerRetiro(int  cantidad)throws  InterruptedException{
        if (cb.getSaldo()>=cantidad) {
            System.out.println(Thread.currentThread().getName()+" esta realizando un retiro de "+ cantidad+".");
            Thread.sleep(200);
            cb.retiroBanco(cantidad);
            System.out.println(Thread.currentThread().getName()+" retiro realizado");
              System.out.println(Thread.currentThread().getName()+" retiro realizado es de: "+ cb.getSaldo());
        }else{
                System.out.println("no hay suficiente ");;
                    System.out.println("se saldo actual de la "+cb.getSaldo());
                    Thread.sleep(2000);  
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                this.HacerRetiro(10);
                if (cb.getSaldo()<0) {
                    System.out.println("La cuenta esta sobregirada");
                }
            } catch (Exception e) {
                System.out.println("Aletta... Registar log de seguridad");
            }
        }
}
    
}
