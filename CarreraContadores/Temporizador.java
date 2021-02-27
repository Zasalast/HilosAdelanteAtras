package CarreraContadores;

import javax.swing.*;

public class Temporizador extends JLabel implements Runnable{
    int hora=0, minutos=0,segundos=0;
    boolean bandera_llegada = true;
    public Temporizador(int hora,int minutos,int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    @Override
    public void run() {
        try {
            while(bandera_llegada){
                this.setText(Tiempo());
                System.out.println("temp");

                Thread.sleep(1000);

            } } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

    String Tiempo(){
        if (getMinutos()== 0 &&getHora()== 0 &&getSegundos()<=0) {
            bandera_llegada = false;
        }else{
        setSegundos(getSegundos()-1);
        if (getSegundos()<0) {
            Thread.currentThread().isInterrupted();
            System.out.println("9");

            setSegundos(59);
            setMinutos(getMinutos()-1);
            if (getMinutos()<0) {
                setMinutos(59);
                setHora(getHora()-1);
            }
        }

        }

        return  ""+hora+":"+minutos+":"+segundos;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public boolean isBandera_llegada() {
        return bandera_llegada;
    }

    public void setBandera_llegada(boolean bandera_llegada) {
        this.bandera_llegada = bandera_llegada;
    }
}
