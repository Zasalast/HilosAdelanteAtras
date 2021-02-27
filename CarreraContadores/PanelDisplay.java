package CarreraContadores;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.lang.reflect.Array;

public class PanelDisplay {

    JLabel Chronos = new JLabel("00:00:00");
    JLabel Lhourt = new JLabel("00:00:00");
    JLabel Ldatet = new JLabel("dd/MM/yyyy");
    JLabel Ltimeout = new JLabel("00:00");
    JPanel jp_controles;

public  JPanel componente(){

    Border jp_b_Controles;
    jp_b_Controles = BorderFactory.createLineBorder(Color.BLACK, 1);
    jp_b_Controles = BorderFactory.createTitledBorder("Tiempo");
    jp_controles = new JPanel();
    jp_controles.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 1));
    jp_controles.setBackground(Color.GRAY);
    jp_controles.setBorder(jp_b_Controles);
    //jp_controles.add(hora_JLabel);
   // jp_controles.add(fecha_JLabel);

    //jp_center_panel.add(jp_controles, BorderLayout.PAGE_END);
    return  jp_controles;
}
    public  void AddComponentes(Component gr){
        jp_controles.add(gr);
    }
}
