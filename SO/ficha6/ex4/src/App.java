import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Semaphore semaforo = new Semaphore(1);
        Tarefa[] threads = new Tarefa[20];

        for (int i = 0; i < 20; i++) {
            threads[i] = new Tarefa(semaforo, i + 1);
            threads[i].start();
        }

        while (true) {
            System.out.print("Insira o número da thread (1-20) para ativar (-1 para sair): ");
            int numeroThread = scanner.nextInt();

            if (numeroThread == -1) {
                // Encerra o programa se -1 for inserido
                break;
            } else if (numeroThread >= 1 && numeroThread <= 20) {
                // Ativa a thread correspondente
                threads[numeroThread - 1].ativar();
            } else {
                System.out.println("Número inválido. Insira um número de 1 a 20.");
            }
        }

        // Aguarda todas as threads terminarem antes de encerrar o programa
        for (int i = 0; i < 20; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}