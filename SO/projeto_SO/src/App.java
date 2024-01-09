import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Crie uma instância do Kernel
        Kernel kernel = new Kernel(3);
        kernel.start();

        Scanner scanner = new Scanner(System.in);

        int escolha;
        do {
            // Exiba o menu
            System.out.println("==== Menu ====");
            System.out.println("1. Adicionar Task");
            System.out.println("2. Executar Task");
            System.out.println("3. Encerrar Programa");
            System.out.print("Escolha: ");

            // Leia a escolha do usuário
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // Adicionar Task
                    System.out.print("Nome da Task: ");
                    String nome = scanner.next();
                    System.out.print("Descrição da Task: ");
                    String descricao = scanner.next();

                    Task task = new Task(nome, descricao);
                    kernel.getMemory().allocateMemory(task);
                    break;
                case 2:
                    // Executar Task
                    task = kernel.readMemory();
                    kernel.getCpu().executeTask(task);
                    kernel.getMemory().releaseMemory(task);
                    break;
                case 3:
                    // Encerrar Programa
                    kernel.stop();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 3);

        System.out.println("Programa encerrado.");
    }
}
