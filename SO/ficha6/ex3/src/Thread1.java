import java.util.Random;
import java.util.concurrent.Semaphore;

public class Thread1 extends Thread {
    private Semaphore semaforo;

    public Thread1(Semaphore semaphor) {
        semaforo = semaphor;
    }

    public void run() {
        try{
            semaforo.acquire();
        System.out.println("Thread 1: Init");

        Random random = new Random();
        int secondsToSleep = random.nextInt(9) + 1;

        try {
            Thread.sleep(secondsToSleep * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 1: End");
        semaforo.release();
        }catch(InterruptedException e){}
    }
}
