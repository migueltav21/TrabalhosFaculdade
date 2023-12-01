public class App {
    public static void main(String[] args) throws Exception {
        Buffer buffer = new Buffer();

        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        // Iniciar as threads
        produtor.start();
        consumidor.start();

        // Aguardar até que ambas as threads terminem
        try {
            produtor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Programa encerrado.");
    }
}

class Produtor extends Thread {
    private final Buffer buffer;

    public Produtor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            char caracter = (char) ('A' + i);

            // Escrever no buffer
            buffer.escreverCaracter(caracter);

            // Aguardar 100 milissegundos
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumidor extends Thread {
    private final Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // Ler do buffer
            char caracter = buffer.lerCaracter();

            System.out.println("Caracter lido: " + caracter);
        }
    }
}

class Buffer {
    private char caracter; // Armazena o caractere no buffer
    private boolean disponivel; // Indica se o buffer contém um caractere disponível para leitura

    // Construtor
    public Buffer() {
        this.disponivel = true; // Inicialmente, o buffer está vazio
    }

    // Método chamado pelo produtor para escrever um caractere no buffer
    public synchronized void escreverCaracter(char c) {
        // Aguardar até que o buffer esteja vazio
        while (!disponivel) {
            try {
                wait(); // A thread produtora espera enquanto o buffer estiver ocupado
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Escrever no buffer
        caracter = c;
        disponivel = false; // Indicar que o buffer contém um caractere disponível para leitura

        // Notificar o consumidor (outra thread) que agora o buffer está ocupado
        notify();
    }

    // Método chamado pelo consumidor para ler um caractere do buffer
    public synchronized char lerCaracter() {
        // Aguardar até que o buffer contenha um caractere
        while (disponivel) {
            try {
                wait(); // A thread consumidora espera enquanto o buffer estiver vazio
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Ler do buffer
        char c = caracter;
        disponivel = true; // Indicar que o buffer está vazio agora

        // Notificar o produtor (outra thread) que o buffer está vazio
        notify();

        // Retornar o caractere lido
        return c;
    }
}
