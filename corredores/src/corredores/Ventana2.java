/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corredores;

/**
 *
 * @author ZASALAS
 */
public class Ventana2 extends JPanel implements  Runnable {
	HiloImagen Hi;
Thread hiloNumeros = new Thread(this);
	
	
	Paneles J;
	Ventana1 vi;


    private Ventana2 canvas23; 
  
	
		public Ventana2(Paneles panelSup, Ventana1 vi) {
		this.J = panelSup;
		this.vi = vi;
		setLayout(null);
		
		
		
		Sound=new SoundTest();
		
		hiloNumeros.start();
	}
	

	@Override
	public void run() {
		while (true) {
			try {
		           
				
			
				Thread.sleep(6000);
			} catch (InterruptedException ex) {
				System.out.println("aqui estoyy");
			}
		}
	}
	


}