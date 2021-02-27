package CarreraContadores;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


import static java.awt.Color.green;

public class PanelCuentaDelante implements Runnable
{
    JTextField  Segundos;



    Object este=null;
    JPanel jp_izquierda;
    public synchronized JPanel components(
                             JPanel jp_centro
                             ){

        Border jp_b_izquierda;
        jp_b_izquierda = BorderFactory.createLineBorder(Color.BLACK, 1);
//
        jp_b_izquierda = BorderFactory.createTitledBorder(jp_b_izquierda,"Cuenta delante");
        jp_izquierda = new JPanel();

        jp_izquierda.setLayout(new GridLayout(2, 0, 10, 10));
//        jp_controles.setBounds(x, y, alt, ancho);
        jp_izquierda.setBackground(Color.GRAY);

        jp_izquierda.setBorder(jp_b_izquierda);

      //  jp_izquierda.add(Segundos);


        jp_centro.add(jp_izquierda, BorderLayout.WEST);
        return jp_centro;
    }



    public  void AddComponentes(Component gr){
        jp_izquierda.add(gr);
    }

    @Override
    public synchronized void run() {
        for (int i = 1000; i >0; i--) {
            CuentaAtras(i); System.out.println("hola2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    void  CuentaAtras(int i){
        System.out.println(i);
        // return ""+i;
    }
}
