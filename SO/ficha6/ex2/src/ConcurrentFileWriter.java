import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class ConcurrentFileWriter extends Thread {
    private static final int MAX_LINES = 10;

    private static Semaphore writeSemaphore = new Semaphore(1);
    private static Semaphore lineSemaphore = new Semaphore(MAX_LINES);
    private String fileName;

    public ConcurrentFileWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            writeLinesToFile();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void writeLinesToFile() throws IOException, InterruptedException {
        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            lineSemaphore.acquire(); // Adquira uma permissão para escrever uma linha
            writeSemaphore.acquire(); // Adquira a trava antes de escrever no arquivo

            bufferedWriter.write("Linha 1\n");
            bufferedWriter.flush(); // Certifique-se de que a linha seja escrita imediatamente

            writeSemaphore.release(); // Libere a trava após escrever a primeira linha
            lineSemaphore.release(); // Libere a permissão para permitir que outras threads escrevam

            Thread.sleep(1000); // Aguarde 1 segundo

            lineSemaphore.acquire(); // Adquira outra permissão para escrever uma segunda linha
            writeSemaphore.acquire(); // Adquira a trava novamente

            bufferedWriter.write("Linha 2\n");
            bufferedWriter.flush(); // Certifique-se de que a linha seja escrita imediatamente

            writeSemaphore.release(); // Libere a trava após escrever a segunda linha
            lineSemaphore.release(); // Libere a permissão

        }
    }
}