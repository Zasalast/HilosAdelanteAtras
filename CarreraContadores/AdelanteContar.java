package CarreraContadores;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

/**
 *
 * @author ZASALAS
 */
public class AdelanteContar extends JTextField implements Runnable{
private int velocidad=1000;
    boolean bandera_llegada = true;
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public AdelanteContar(int velocidad) {
      //  this.velocidad = velocidad;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i <= 10; i++) {
            this.setText(""+i);
            System.out.println("hilo    "+" "+i);
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
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
