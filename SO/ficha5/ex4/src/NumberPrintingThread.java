import java.util.concurrent.Semaphore;

public class NumberPrintingThread extends Thread {
    private int numInicial;
    private int numDeImpressoes;
    private Semaphore semaphore;

    public NumberPrintingThread(int num, int num2, Semaphore semaforo) {
        numInicial = num;
        numDeImpressoes = num2;
        semaphore = semaforo;
//aaaaa
    }

    public void run() {
        try {
            semaphore.acquire();
            for (int i = numInicial; i < (numDeImpressoes + numInicial); i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}
