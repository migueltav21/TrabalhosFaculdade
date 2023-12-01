import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janela implements Runnable {
    protected Monitor m;
    protected int i;

    public Janela(Monitor m, int i) {
        this.m = m;
        this.i = i;
    }

    public void run() {
        String mynane = Thread.currentThread().getName();
        JFrame f = new JFrame(mynane);
        JLabel l = new JLabel("#");
        f.add(l);
        f.setSize(150, 200);
        f.setLocation(i * 200, 100);
        f.setVisible(true);
        
        m.espera(i+1);

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
            }
            l.setText("" + l.getText() + "#");
        }
        f.dispose();
    }
}
