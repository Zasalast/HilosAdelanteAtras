package CarreraContadores;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
// import java.util.Timer;
import static java.awt.Color.green;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ZASALAS
 */
public class VentanaPrincipalCarrera extends JFrame implements ActionListener ,
        WindowListener,
        ChangeListener {
    Temporizador tempo;
    HoraActual fech;
    Cronometro cronos;
    AdelanteContar adelante_contar;
    AtrasContar atras_contar;
    PanelDisplay jp_controles,jp_informe;

    JPanel jp_center_panel, jp_centro;
    PanelCuentaAtras jp_derecha;
    PanelCuentaDelante jp_izquierda;

    Timer control_hilo_ejecucion;
    java.util.Timer timer;

    Thread   cronoshilo,tempohilo,relohilo,adelante_contarhilo,atras_contarhilo;
    JTextField Horas, Minutos, Segundos;
    JLabel fecha_JLabel, hora_JLabel;
   JButton btn_iniciar, btn_pausar, btn_reanudar, btn_parar, btn_iniciar_cuenta_delante, btn_pausar_cuenta_delante, btn_reiniciar_cuenta_delante, btn_parar_cuenta_delante;
  JSlider silder1, silder2;

    //Set up animation parameters.
    static final int FPS_MIN = 100;
    static final int FPS_MAX = 400;
    static final int FPS_INIT = 100;

    boolean bandera_llegada = true;
    int velocidad_ejecucion,velocidad_ejecucion1;



    void JSilderComponents() {
        silder1 = new JSlider(JSlider.HORIZONTAL,
                FPS_MIN, FPS_MAX, FPS_INIT);
        silder1.addChangeListener(this);
        silder1.setPaintTicks(true);
        silder1.setMajorTickSpacing(100);
        silder1.setPaintLabels(true);
        silder1.setBorder(BorderFactory.createTitledBorder("Velocidad"));
        silder2 = new JSlider(JSlider.HORIZONTAL,
                FPS_MIN, FPS_MAX, FPS_INIT);
        silder2.addChangeListener(this);

        silder2.setPaintTicks(true);
        silder2.setMajorTickSpacing(100);
        silder2.setPaintLabels(true);
        silder2.setBorder(BorderFactory.createTitledBorder("Velocidad"));
    }



    public VentanaPrincipalCarrera(String title, int ancho, int alto, boolean bloqueo_ventana, boolean Visible_ventana) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout(2, 2));
        setSize(ancho + 10, alto + 40);//ancho , alto
        setBackground(Color.GRAY);///color fondo
        setLocationRelativeTo(null);//centro de pantallla
//        getContentPane().setBackground(Color.black);
        setResizable(bloqueo_ventana);//cambiar tamaño de pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CenterPanel();
        Components();
        ControlesPanelFlowLayout();
        panelCentro();
        PanelDerecha();
        PanelControlCuentaDelante();
        jp_center_panel.add(jp_centro, BorderLayout.CENTER);

this.setVisible(Visible_ventana);
        control_hilo_ejecucion = new Timer(10000, this);
        //control_hilo_ejecucion.setInitialDelay(velocidad_ejecucion * 7); //We pause animation twice per cycle
        //by restarting the timer
        control_hilo_ejecucion.setCoalesce(true);
        timer = new java.util.Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
    TimerTask timerTask = new TimerTask()
    {
        /**
         * Método al que Timer llamará cada segundo. Se encarga de avisar
         * a los observadores de este modelo.
         */
        public void run()
        {
            if (!adelante_contar.isBandera_llegada() && !atras_contar.isBandera_llegada()){
                cronos.setBandera_llegada(false);
                tempo.setBandera_llegada(false);
                fech.setBandera_llegada(false);
                System.out.println(" Entro time");
                System.out.println(" Entro time");
                System.out.println(" Entro time");
                System.out.println(" Entro time");
                System.out.println(" Entro time");
                timerTask.notify();
                try {
                    timerTask.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("No Entro time");
            System.out.println("No Entro time");
            System.out.println("No Entro time");
            System.out.println("No Entro time");
            System.out.println("No Entro time");

        }
    };
    public synchronized void CenterPanel() {
        jp_center_panel  = new JPanel();
        jp_center_panel.setLayout(new BorderLayout(5, 5));
        jp_center_panel.setBackground(Color.lightGray);
        jp_center_panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        this.add(jp_center_panel);
    }

    public synchronized void panelCentro() {
        Border jp_b_Centro;
        jp_b_Centro = BorderFactory.createLineBorder(Color.BLACK, 1);
        jp_b_Centro = BorderFactory.createTitledBorder("Central");
        jp_centro = new JPanel();
        jp_centro.setLayout(new GridLayout(2, 0, 10, 10));
        jp_centro.setBackground(Color.GRAY);
        jp_centro.setBorder(jp_b_Centro);

    }

    public  synchronized void PanelDerecha() {
        jp_derecha =new PanelCuentaAtras();
        jp_derecha.components( jp_centro
                );
        jp_derecha.AddComponentes(atras_contar);
        jp_derecha.AddComponentes(silder2);

    }

    public synchronized void PanelControlCuentaDelante() {
        jp_izquierda=new PanelCuentaDelante();

        jp_izquierda.components(
                 jp_centro);jp_izquierda.AddComponentes(adelante_contar);
        jp_izquierda.AddComponentes(silder1);

    }

    public synchronized void ControlesPanelFlowLayout() {

        jp_controles=new PanelDisplay();
        jp_center_panel.add(jp_controles.componente(),
                BorderLayout.PAGE_END);

        jp_informe=new PanelDisplay();
        jp_center_panel.add(jp_informe.componente(),
                BorderLayout.PAGE_START);

        jp_informe.AddComponentes(cronos);
        jp_informe.AddComponentes(fech);
        jp_informe.AddComponentes(tempo);
        jp_controles.AddComponentes(btn_iniciar);
        jp_controles.AddComponentes(btn_pausar);
        jp_controles.AddComponentes(btn_reanudar);
        jp_controles.AddComponentes(btn_parar);
    }


    void  Components() {
        JSilderComponents();
        JTextFieldsComponents();
        JButtonComponents();
        JLabelComponents();

    }

    public synchronized void iniciarEjecucion() {
        //Start (or restart) animating!
        control_hilo_ejecucion.start();
        bandera_llegada = false;

        btn_iniciar.setEnabled(false);
        btn_parar.setEnabled(true);
        atras_contar.setEditable(false);
        adelante_contar.setEditable(false);
        relohilo.start();
        cronoshilo.start();
        tempohilo.start();
        adelante_contarhilo.start();
        atras_contarhilo.start();

    }


    public synchronized void pausarEjecucion() {
        //Stop the animating thread.
        control_hilo_ejecucion.stop();
        bandera_llegada = true;

        btn_reanudar.setEnabled(true);
        relohilo.suspend();
        cronoshilo.suspend();
        tempohilo.suspend();
        adelante_contarhilo.suspend();
        atras_contarhilo.suspend();
    }


    public synchronized void reanudarEjecucion() {
        //Stop the animating thread.
        control_hilo_ejecucion.stop();
        bandera_llegada = true;
        btn_parar.setEnabled(true);
        btn_pausar.setEnabled(true);
        relohilo.stop();
        cronoshilo.stop();
        tempohilo.stop();
        adelante_contarhilo.stop();
        atras_contarhilo.stop();
    }



    public synchronized void detenerEjecucion() {
        //Stop the animating thread.
       control_hilo_ejecucion.stop();
        bandera_llegada = true;


        relohilo.stop();
        cronoshilo.stop();
        tempohilo.stop();
        adelante_contarhilo.stop();
        atras_contarhilo.stop();
    }



    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == silder1) {

            silder1 = (JSlider)e.getSource();
           // if (!silder1.getValueIsAdjusting()) {
                int fps = (int)silder1.getValue();
                setVelocidad_ejecucion(fps);
                adelante_contar.setVelocidad(fps);
           // }
        }

        if (e.getSource() == silder2) {
            silder2 = (JSlider)e.getSource();

            int fps = (int)silder2.getValue();
            setVelocidad_ejecucion1(fps);
             atras_contar.setVelocidad(fps);

        }
    }

    @Override
    public synchronized void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn_iniciar) {
            iniciarEjecucion();
        } else if(e.getSource() == btn_parar){
            detenerEjecucion();
            relohilo.stop();
            cronos.setBandera_llegada(false);
            tempohilo.stop();
            adelante_contarhilo.stop();
            atras_contarhilo.stop();
            System.out.println("pare");
        }
    }

        void JLabelComponents() {
        fech=new HoraActual();
        relohilo=new Thread(fech);

             cronos=new Cronometro();
            cronoshilo=new Thread(cronos);

             tempo=new Temporizador(0,1,6);
            tempohilo=new Thread(tempo);
       // fecha_JLabel = new JLabel(""+fech.Fecha());
       // hora_JLabel = new JLabel(" "+fech.hora());
    }

    void JButtonComponents() {
        btn_iniciar = new JButton("Iniciar");
        btn_iniciar.setEnabled(true);
          btn_iniciar.addActionListener(this);
        btn_pausar = new JButton("Pausa");
        btn_pausar.setEnabled(false);
         btn_pausar.addActionListener(this);
        btn_reanudar = new JButton("Reiniciar");
        btn_reanudar.setEnabled(false);
        btn_reanudar.addActionListener(this);
        btn_parar = new JButton("Parar");
        btn_parar.setEnabled(false);
        btn_parar.addActionListener( this);

    }    void JTextFieldsComponents() {

        Border bt_minutos;
        bt_minutos = BorderFactory.createLineBorder(green, 1);

        bt_minutos = BorderFactory.createTitledBorder(bt_minutos,"0-1000 Segundos");
        Minutos = new JTextField("0");
        Minutos.setBorder(bt_minutos);

        Border bt_adelante_contar;
        bt_adelante_contar = BorderFactory.createLineBorder(green, 1);

        bt_adelante_contar = BorderFactory.createTitledBorder(bt_adelante_contar,"0-1000 Segundos");
        adelante_contar=new AdelanteContar(getVelocidad_ejecucion());
        adelante_contarhilo=new Thread(adelante_contar);
        adelante_contar.setBorder(bt_adelante_contar);
        adelante_contar.setEditable(false);

        atras_contar=new AtrasContar(getVelocidad_ejecucion1());
        atras_contar.setBorder(bt_minutos);
        atras_contar.setEditable(false);
        atras_contarhilo=new Thread(atras_contar);
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        detenerEjecucion();
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
iniciarEjecucion();
    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public int getVelocidad_ejecucion() {
        return velocidad_ejecucion;
    }

    public void setVelocidad_ejecucion(int velocidad_ejecucion) {
        this.velocidad_ejecucion = velocidad_ejecucion;
    }

    public int getVelocidad_ejecucion1() {
        return velocidad_ejecucion1;
    }

    public void setVelocidad_ejecucion1(int velocidad_ejecucion1) {
        this.velocidad_ejecucion1 = velocidad_ejecucion1;
    }
}
