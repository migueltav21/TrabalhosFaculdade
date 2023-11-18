import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {
        int NUM_THREADS = 20;
        if (args.length != 1) {
            System.out.println("Uso: java ConcurrentFileWriter <nome_do_arquivo>");
            System.exit(1);
        }

        String fileName = args[0];

        for (int i = 0; i < NUM_THREADS; i++) {
            ConcurrentFileWriter  thread = new ConcurrentFileWriter (fileName);
            thread.start();
        }
    }
}
