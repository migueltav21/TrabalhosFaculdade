import java.util.concurrent.Semaphore;

public class Tarefa extends Thread {
    private Semaphore semaforo;
    private int numeroThread;
    private boolean ativa;

    public Tarefa(Semaphore semaphor, int num) {
        this.semaforo = semaphor;
        this.numeroThread = num;
        this.ativa = false;
    }

    public void run() {
            try {
                while (true) {
                    if (ativa) {
                        System.out.println("Thread " + numeroThread + " está ativa.");
                        Thread.sleep(1000);
                    }
                    semaforo.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public void ativar() {
        ativa = true;
        try {
            semaforo.acquire();
        } catch (InterruptedException e) {

        }
    }

    public void desativar() {
        ativa = false;
        semaforo.release();
    }
}
