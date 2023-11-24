import java.util.Random;
import java.util.concurrent.Semaphore;

public class Thread2 extends Thread{
    private Semaphore semaforo;

    public Thread2(Semaphore semaphor) {
        semaforo = semaphor;
    }

    public void run(){
        try{
            semaforo.acquire();
    System.out.println("Thread 2: Init");

        Random random = new Random();
        int linesToPrint = random.nextInt(9) + 1;

        for (int i = 1; i <= linesToPrint; i++) {
            System.out.println("Thread 2: Line " + i);
        }

        System.out.println("Thread 2: End");
        semaforo.release();
    }catch(InterruptedException e){}
    }
    }
