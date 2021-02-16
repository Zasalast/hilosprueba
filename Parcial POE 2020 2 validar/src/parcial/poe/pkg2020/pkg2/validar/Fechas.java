/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial.poe.pkg2020.pkg2.validar;


import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ZASALAS
 */
public class Fechas {
    private JDateChooser jDateChooser1;
    JCalendar jdc;
//    Calendar calendario;
    SimpleDateFormat formateadr, formateadr1, formateadr2, formateadr3;
    void components(){
         formateadr = new SimpleDateFormat("dd-MM-yyyy");
        formateadr1 = new SimpleDateFormat("DD-MM-yyyy");
        formateadr2 = new SimpleDateFormat("yyyy-MM-dd");
        formateadr3 = new SimpleDateFormat("h:mm a");
        
//        jdc = new JCalendar();
//        jdc.setTodayButtonVisible(true);
//        jdc.setTodayButtonText("hot es");
//        calendario = new GregorianCalendar();
//        jdc.setDate(calendario.getTime());
//        jdc.setMaxSelectableDate(new Date());
    }
    void edad(Calendar calendario){
        System.out.println("edad");
              System.out.println("edad:  "+ Calendar.DAY_OF_MONTH+"  /"+calendario.MONTH+"/  "+calendario.YEAR);
           System.out.println ("" + Calendar.DAY_OF_MONTH+"/"+Calendar.MONTH+"/"+Calendar.YEAR);
            System.out.println(""+ jdc.getCalendar());
    }
    String horaActual(Calendar calendario){
      return ("" + formateadr3.format(calendario.getTime()));
    }
    String FechaActual(Calendar calendario){
       return ("" + formateadr.format(calendario.getTime()));
    }
}
