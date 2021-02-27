package CarreraContadores;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelCuentaAtras
       implements Runnable
{
    JTextField Horas, Minutos;
    JLabel fecha_JLabel, hora_JLabel;
String cont="";
    HoraActual fech;

JPanel jp_derecha;
    public synchronized JPanel components(   JPanel jp_centro

    ){
        Border jp_b_derecha;
        jp_b_derecha = BorderFactory.createLineBorder(Color.BLACK, 1);
//
        jp_b_derecha = BorderFactory.createTitledBorder(jp_b_derecha,"Cuenta Atras");
         jp_derecha = new JPanel();

        jp_derecha.setLayout(new GridLayout(2, 0, 10, 10));
//        jp_controles.setBounds(x, y, alt, ancho);
        jp_derecha.setBackground(Color.GRAY);

        jp_derecha.setBorder(jp_b_derecha);

       // jp_derecha.add(Minutos);
        jp_centro.add(jp_derecha, BorderLayout.EAST);
        return jp_centro;
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == btn_iniciar) {
////            Horas.setEditable(false);
//            btn_iniciar.setEnabled(false);
//            Minutos.setEditable(false);
////            Segundos.setEditable(false);
////            Tempo = new Temporizador(Integer.parseInt(Horas.getText()), Integer.parseInt(Minutos.getText()), Integer.parseInt(Segundos.getText()));
//
////  Tempo = new Temporizador(  Integer.parseInt(Segundos.getText()));
////            Tempo.start();
//
//        } else if (e.getSource() == btn_pausar) {
//            //Tempo.suspend();
//        } else if (e.getSource() == btn_reiniciar) {
//            //Tempo.resume();
//        } else if (e.getSource() == btn_parar) {
////            Tempo.stop();
//        }
//    }
public  void AddComponentes(Component gr){
     jp_derecha.add(gr);
}

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            CuentaAtras(i);
            System.out.println("hola1");
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
