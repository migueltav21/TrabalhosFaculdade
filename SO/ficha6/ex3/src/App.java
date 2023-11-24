import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) throws Exception {
        Semaphore semaphore1 = new Semaphore(1);
        Thread1 thread1 = new Thread1(semaphore1);
        Thread2 thread2 = new Thread2(semaphore1);

        thread1.start();
        thread2.start();

    }
}
