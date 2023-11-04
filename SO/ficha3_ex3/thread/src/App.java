public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Tem de passar um número como argumento");
            return;
        }

        int numSec = Integer.parseInt(args[0]);

        Thread thread = new Thread(new MyRunnable());
        thread.start();

        try {
            Thread.sleep(numSec * 1000);
        } catch (InterruptedException e) {
            System.out.println("thread interrompida");
        }

        thread.interrupt();
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("linha " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrompida.");
                    return;
                }
            }
        }
    }
}
