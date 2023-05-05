package Model;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
/**
 *
 * @author Jaqueline
 */
public class Contador {
    
    private int tempoRestante;
    private JLabel LabelContador;

    public Contador(int segundos) {
          this.tempoRestante = segundos;
          this.LabelContador = new JLabel();
    }
    
    public Contador(int segundos, JLabel labelContador) {
    this.tempoRestante = segundos;
    this.LabelContador = labelContador;
    }
    
    public void iniciarContagem() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            tempoRestante--;
            LabelContador.setText(Integer.toString(tempoRestante));
                if (tempoRestante == 0) {
                    timer.cancel();
              }
            }
        }, 0, 1000);
    }
    
    public static void main(String[] args) {
        Contador contador = new Contador(60);
        contador.iniciarContagem();
    }
}
