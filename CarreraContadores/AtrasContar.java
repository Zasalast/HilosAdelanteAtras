package CarreraContadores;

import javax.swing.*;

public class AtrasContar extends JTextField implements Runnable{
    private int velocidad=1000;
    boolean bandera_llegada = true;
    public AtrasContar(int velocidad) {
       // this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    @Override
    public synchronized void run() {
        int i=10;
        while (bandera_llegada){
            if (i > 0){
                i--;
                this.setText(""+i);
                System.out.println("hilo    "+" "+i);
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }else{
                bandera_llegada=false;
            }

        }
        System.out.println("termino atras");
    }

    public boolean isBandera_llegada() {
        return bandera_llegada;
    }

    public void setBandera_llegada(boolean bandera_llegada) {
        this.bandera_llegada = bandera_llegada;
    }
}

