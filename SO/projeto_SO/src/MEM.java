import java.util.concurrent.Semaphore;
import Queue.LinkedQueue;

public class MEM extends Thread {
    private LinkedQueue<Task> memory;
    private int max_size;
    private int size;
    private Semaphore semaphore = new Semaphore(1);

    public MEM(int memorySize) {
        this.memory = new LinkedQueue<>();
        this.max_size = memorySize;
        this.size = 0;
    }

    public void run() {
        System.out.println("MEM iniciada.");

        try {
            while (!Thread.interrupted()) {
                // Aguarde um curto período antes da próxima iteração
                Thread.sleep(1000); // Aguarde por 1 segundo (pode ajustar conforme necessário)
            }
        } catch (InterruptedException e) {
        }

        System.out.println("MEM encerrada.");
    }

    public void allocateMemory(Task task) {
        try {
            semaphore.acquire(); // Adquire a licença do semáforo

            // Lógica para alocar memória
            if (this.getSize() < this.getMax_size()) {
                memory.enqueue(task);
                System.out.println("Task alocada em memoria");
                size++;
                // Faça algo com os dados, se necessário
            } else {
                System.out.println("Nao existe mais espaco em memoria.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Libera a licença do semáforo
        }
    }

    public Task readMemory() {
        try {
            semaphore.acquire(); // Adquire a licença do semáforo
            if (size > 0) {
                Task oldestTask = memory.first();
                return oldestTask;
            } else {
                return null;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            semaphore.release(); // Libera a licença do semáforo
        }
    }

    public void releaseMemory(Task task) {
        try {
            if(task != null) {
                semaphore.acquire(); // Adquire a licença do semáforo
                memory.dequeue();
                size--;
            }else{

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Libera a licença do semáforo
        }
    }

    public LinkedQueue<Task> getMemory() {
        return memory;
    }

    public void setMemory(LinkedQueue<Task> memory) {
        this.memory = memory;
    }

    public int getMax_size() {
        return max_size;
    }

    public void setMax_size(int max_size) {
        this.max_size = max_size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
}
