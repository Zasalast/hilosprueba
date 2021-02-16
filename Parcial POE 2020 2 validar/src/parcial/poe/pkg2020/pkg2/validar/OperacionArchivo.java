/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial.poe.pkg2020.pkg2.validar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionArchivo {

    public static String crear_archivo_plano(String name, String content) throws IOException {
        String ruta = "C:/Users/ZASALAS/Documents/NetBeansProjects/JavaApplication9/src/javaapplication9/src/main/java/tallernotas/";
        name += ".txt";
        
      
         FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            flwriter = new FileWriter(ruta+name);
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
          
                //escribe los datos en el archivo
                bfwriter.write( content);
            
            //cierra el buffer intermedio
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");

        } catch (IOException e) {
            
            e.printStackTrace();
             try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
            flwriter = new FileWriter(ruta + name
//                    "C:/Users/ZASALAS/Documents/NetBeansProjects/JavaApplication9/src/javaapplication9/src/main/java/tallernotas/estudiantes4.txt"
            , true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            //escribe los datos en el archivo
                bfwriter.write(content);
            
            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
 
        return "ARCHIVO CREADO CON EXITO...\n";
    }

    //crea el archivo en disco, retorna la lista de estudiantes
    public static ArrayList leerArchivo(String name) {
        name += ".txt";
         String ruta = "C:/Users/ZASALAS/Documents/NetBeansProjects/JavaApplication9/src/javaapplication9/src/main/java/tallernotas/";
        // crea el flujo para leer desde el archivo
        File file = new File(ruta + name);
        ArrayList listaEstudiantes = new ArrayList<>();
        Scanner scanner;
        try {
            //se pasa el flujo al objeto scanner
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // el objeto scanner lee linea a linea desde el archivo
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                //se usa una expresión regular
                //que valida que antes o despues de una coma (,) exista cualquier cosa
                //parte la cadena recibida cada vez que encuentre una coma				
                delimitar.useDelimiter("\\s*,\\s*");
                Erroress e = new Erroress();
                 
                 
                e.setError(delimitar.next());
              
                listaEstudiantes.add(e);
            }
            //se cierra el ojeto scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaEstudiantes;
    }
 //añadir más estudiantes al archivo
    public static void aniadirArchivo(ArrayList lista,String name) {
        name += ".txt";
         String ruta = "C:/Users/ZASALAS/Documents/NetBeansProjects/JavaApplication9/src/javaapplication9/src/main/java/tallernotas/";
        ArrayList listaEstudiantes = new ArrayList();
        FileWriter flwriter = null;
        try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
            flwriter = new FileWriter(ruta + name
//                    "C:/Users/ZASALAS/Documents/NetBeansProjects/JavaApplication9/src/javaapplication9/src/main/java/tallernotas/estudiantes4.txt"
            , true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for (Erroress estudiante : (ArrayList<Erroress>) lista) {
                //escribe los datos en el archivo
                bfwriter.write(  estudiante.getError()+    "\n");
            }
            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    

}