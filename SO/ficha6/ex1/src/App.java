public class App {
    public static void main(String[] args) throws Exception {
        int NUM_THREADS = 5;
        int NUM_NUMBERS = 200;
        if (args.length != 1) {
            System.out.println("Uso: java ThreadedFileWriter <nome_do_arquivo>");
            System.exit(1);
        }

        String fileName = args[0];

        for (int i = 0; i < NUM_THREADS; i++) {
            ThreadFileWriter thread = new ThreadFileWriter(fileName);
            thread.start();
        }
    }
}
