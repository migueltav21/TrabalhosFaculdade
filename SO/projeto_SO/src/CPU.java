import java.util.concurrent.Semaphore;

public class CPU extends Thread {
    private Semaphore semaphore = new Semaphore(1);

    public CPU(MEM memory) {
    }

    public void run() {
        System.out.println("CPU iniciada.");

        try {
            while (!Thread.interrupted()) {
                // Aguarde um curto período antes da próxima iteração
                Thread.sleep(1000); // Aguarde por 1 segundo (pode ajustar conforme necessário)
            }
        } catch (InterruptedException e) {
            // Lida com a interrupção da thread, se necessário
        }

        System.out.println("CPU encerrada.");
    }

    public void executeTask(Task task) {
        try {
            semaphore.acquire(); // Adquire a licença do semáforo

            // Lógica para executar uma tarefa
            if (task != null) {
                task.run();
            } else {
                System.out.println("Nenhuma tarefa disponível para execução.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Libera a licença do semáforo
        }
    }
}
