package ventanas;
import acciones.Pomodoro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class VentanaPomodoro extends JFrame {
    JPanel panel = new JPanel();

    public void vista() {
        configuracionPestania();
        componentes();
    }

    public void configuracionPestania() {
        this.setTitle("Pomodoro");
        this.setLocationRelativeTo(null);
        this.setSize(600, 400);
        this.setVisible(true);
        this.add(panel);
        panel.setLayout(null);
    }

    public void componentes() {
        //Configuración del título
        JLabel mensaje = new JLabel("Pomodoro");
        mensaje.setBounds(185, 20, 300, 150);
        mensaje.setFont(new Font("Serif", Font.BOLD, 36));
        panel.add(mensaje);

        //Configuración de subtítulo
        final JTextField textoTiempo = new JTextField("Minutos");
        textoTiempo.setBounds(185, 150, 100, 25);
        panel.add(textoTiempo);

        //Configuración de botón play
        ImageIcon icon = new ImageIcon("E:\\Productivity_app\\Productivity_App\\imagenes\\playbutton.png");
        Image img = (icon).getImage();
        Image newimg = img.getScaledInstance(50, 50, 50); //redimensiono la img

        JButton play = new JButton(new ImageIcon(newimg));
        play.setBounds(200, 200, 50, 50);
        panel.add(play);

        // Una vez apretado el botón, el tiempo se pone en marcha
        ActionListener botonPlay = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se agarra el tiempo ingresado y se pasa a milisegundos
                int tiempo = Integer.parseInt(textoTiempo.getText());
                final long tiempoL = (long) tiempo * 60 * 1000;
                textoTiempo.setEditable(false);

                //Configuracion del texto del tiempo restante
                final JLabel textoTiempoRestante = new JLabel();
                textoTiempoRestante.setBounds(185, 250, 100, 25);
                panel.add(textoTiempoRestante);

                Timer timer = new Timer();
                final Pomodoro exp = new Pomodoro();
                exp.setValor(0L);

                TimerTask tarea = new TimerTask() {
                    @Override
                    public void run() {

                        int segundos = (int) (((tiempoL - exp.valor) / 1000) % 60);
                        int min = (int) (((tiempoL - exp.valor) / (1000 * 60)) % 60);
                        int hour = (int) (((tiempoL - exp.valor) / (1000 * 60)) / 60);

                        textoTiempoRestante.setText(hour + ":" + min + ":" + segundos);
                        exp.setValor(exp.valor + 1000); //setea el valor del tiempo transcurrido
                    }
                };
                timer.schedule(tarea, 0, 1000);
            }
        };
        play.addActionListener(botonPlay);
    }
}