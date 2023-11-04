public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Tem de passar um número como argumento");
            return;
        }

        int numThreads = Integer.parseInt(args[0]);

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new MyRunnable(i));
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {
        private int num;

        public MyRunnable(int n){
            this.num = n;
        }

        @Override
        public void run() {
            System.out.println("[Th" + this.num + "]Eu sou uma thread");
        }
    }
}
