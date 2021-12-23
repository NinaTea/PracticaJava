package ventanas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    JPanel panel = new JPanel();

    public void vista(){
        configuracionPestania();
        componentes();
        botones();
    }

    public  void configuracionPestania(){
        this.setTitle("Productivity Program");
        this.setLocationRelativeTo(null);
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(panel);
        panel.setLayout(null);
    }

    public void componentes(){
        String msj = "¡Hola! ¿Por dónde arrancamos hoy?";
        JLabel mensaje = new JLabel(msj);
        mensaje.setBounds(185,85,250,25);
        panel.add(mensaje);
    }

    private void botones(){
        JButton pomodoro = new JButton("Pomodoro");
        pomodoro.setBounds(112,150,100,30);

        JButton lista = new JButton("Lista de tareas");
        lista.setBounds(225,150,150,30);
/*
        JButton calendario = new JButton("Calendario");
        calendario.setBounds(389,150,100,30);
*/
        panel.add(pomodoro);
        panel.add(lista);
        //panel.add(calendario);

        ActionListener oyenteP = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPomodoro pestañaPomodoro = new VentanaPomodoro();
                pestañaPomodoro.vista();
            }
        };
        /*      ActionListener oyenteL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaListaDeTareas listaTareas = new VentanaListaDeTareas();
                listaTareas.vista();
            }
        }; */

        ActionListener oyenteL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel s = new JLabel();
                panel.add(s);

                s.setBounds(100,200,150,50);
                s.setText("En construcción");
            }
        };

        pomodoro.addActionListener(oyenteP);
        lista.addActionListener(oyenteL);

    }
}