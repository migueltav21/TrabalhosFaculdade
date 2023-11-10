public class Run extends Thread {
    public SharedObj share;

    public Run(SharedObj s) {
        share = s;
    }

    public void run() {
        String myname = Thread.currentThread().getName();
        try {
            while (!Thread.interrupted()) {
                printSharedObjectInfo(myname);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrompida");
        }
    }

    private synchronized void printSharedObjectInfo(String myname) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("[" + myname + "]Number:" + share.getNumber() + "(" + share.getName() + ")");
    }

        public void setShare(SharedObj s) {
            share = s;
        }
    }