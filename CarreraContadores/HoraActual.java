package CarreraContadores;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
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
public class HoraActual extends JLabel implements Runnable{
    SimpleDateFormat formateadr, formateadr1, formateadr2, formateadr3,formateadr4;
    JCalendar jdc;
    boolean bandera_llegada = true;
    public HoraActual() {
        this.setHorizontalAlignment((SwingConstants.CENTER));//Se Pinta en el centro del JLabel
        this.setPreferredSize(new Dimension(100, 40));// dimension JLabel.
        JDateChooser jDateChooser1;
        Calendar calendario;

        formateadr = new SimpleDateFormat("dd-MM-yyyy");
        formateadr1 = new SimpleDateFormat("DD-MM-yyyy");
        formateadr2 = new SimpleDateFormat("yyyy-MM-dd");
        formateadr3 = new SimpleDateFormat("h:mm a");
        formateadr4 = new SimpleDateFormat("hh:mm:ss");

        jdc = new JCalendar();
        jdc.setTodayButtonVisible(true);
        jdc.setTodayButtonText("hot es");
        calendario = new GregorianCalendar();
        jdc.setDate(calendario.getTime());
        jdc.setMaxSelectableDate(new Date());
        this.setText("" + formateadr4.format(new Date()));
    }

    String hora() {
        components();
        return  "aa"+formateadr3.format(jdc.getDate());
    }
    String Fecha() {
        components();
        return  "hola"+formateadr1.format(jdc.getDate());
    }
    void components(){

    }

    @Override
    public void run() {
        while (bandera_llegada){
            this.setText("" + formateadr4.format(new Date()));
            System.out.println("hora actual");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isBandera_llegada() {
        return bandera_llegada;
    }

    public void setBandera_llegada(boolean bandera_llegada) {
        this.bandera_llegada = bandera_llegada;
    }
}
