public class App {
    public static void main(String[] args) throws Exception {
        Monitor mon = new Monitor();
        Thread[] ths = new Thread[8];

        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(new Janela(mon, i), "Th" + i);
            ths[i].start();
            Thread.sleep(100);

            synchronized (mon) {
                // Notifica o monitor para liberar as threads que estão esperando
                mon.notifyAll();
            }
            
        }
        System.out.println("[Main]_All_threads_created");
        System.out.println("[Main]_Activing_threads");

        try {
            for (int i = 0; i < ths.length; i++) {
                ths[i].join();
            }
        } catch (InterruptedException ie) {
        }
        System.out.println("[Main]_All_threads_ended");

    }

}
