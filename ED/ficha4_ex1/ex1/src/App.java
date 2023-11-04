public class App {
    public static void main(String[] args) throws Exception {
        Queue<String> queue = new Queue<>();
        queue.enqueue("miguel");
        queue.enqueue("joao");
        queue.enqueue("pedro");
        queue.enqueue("kiko");
        System.out.println(queue.toString());

        System.out.println("Front: " + queue.first());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Queue after dequeue:\n" + queue.toString());

        MEnsagem mensagem = new MEnsagem("Eu sou o melhor");
        mensagem.printMensagem();
        mensagem.codificarMensagem(27);
        mensagem.printMensagem();
        mensagem.descodificarMensagem();
        mensagem.printMensagem();

        JuntarQueue<String> duasQueus = new JuntarQueue<>();
        duasQueus.printQueuesJuntas();
        Queue<String> queue2 = new Queue<>();
        queue2.enqueue("O miguel");
        queue2.enqueue("e o joao sao irmaos");
        Queue<String> queue3 = new Queue<>();
        queue3.enqueue("eles estao a brincar");
        duasQueus.juntar_queue(queue2, queue3);
        duasQueus.printQueuesJuntas();

    }
}
