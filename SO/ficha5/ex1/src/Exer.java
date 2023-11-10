public class Exer {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);
        threadA.start();
        threadB.start();
        
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Tempo de execucao: " + executionTime + " milissegundos");
  
    }
}
