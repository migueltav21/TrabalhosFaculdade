import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) throws Exception {
        final int numThreads = 10;
        final int numPorThread = 100;
        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < numThreads; i++) {
            int startingValue = i * numPorThread;
            Thread thread = new NumberPrintingThread(startingValue, numPorThread, semaphore);
            thread.start();
        }
    }
}
