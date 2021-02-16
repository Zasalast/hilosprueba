
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZASALAS
 */
public class Fechaa {
     JCalendar jdc;
    private JDateChooser jDateChooser1;
    Calendar calendario;
    SimpleDateFormat formateadr, formateadr1, formateadr2, formateadr3;
       void JCalendarComponents() {
        formateadr = new SimpleDateFormat("dd-MM-yyyy");
        formateadr1 = new SimpleDateFormat("DD-MM-yyyy");
        formateadr2 = new SimpleDateFormat("yyyy-MM-dd");
        formateadr3 = new SimpleDateFormat("h:mm a");

        jdc = new JCalendar();
        jdc.setTodayButtonVisible(true);
        jdc.setTodayButtonText("hot es");
        calendario = new GregorianCalendar();
        jdc.setDate(calendario.getTime());
        jdc.setMaxSelectableDate(new Date());
    }
}
