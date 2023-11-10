public class doThreadSharing {
    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        SharedObj share = new SharedObj();
        Thread tarefa = new Thread(new Run(share), "Printer_thread");
        tarefa.start();
        for (int i = 0; i < 10; i++) {
            Thread tarefa2 = new Thread(new Run2(share, i));
            tarefa2.setName("Numbered_thread" + i);
            tarefa2.start();
        }
        try {
            Thread.sleep(10000);
            tarefa.interrupt();
        } catch (InterruptedException e) {
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Tempo de execucao: " + executionTime + " milissegundos");
    }
}
