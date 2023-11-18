import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class ThreadFileWriter extends Thread {
    private static final int NUM_THREADS = 5;
    private static final int NUM_NUMBERS = 200;

    private static Semaphore semaphore = new Semaphore(1);
    private String fileName;

    public ThreadFileWriter(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        try {
            writeNumbersToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeNumbersToFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (int i = 1; i <= NUM_NUMBERS; i++) {
                try {
                    semaphore.acquire(); // Adquira a permissão antes de escrever no arquivo
                    bufferedWriter.write(i + "\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // Libere a permissão após escrever no arquivo
                }
            }
        }
    }
}
