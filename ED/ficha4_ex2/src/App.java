public class App {

    public static void main(String[] args) throws Exception {
        CircularArrayQueue<String> queue = new CircularArrayQueue<>();
        queue.enqueue("miguel");
        queue.enqueue("joao");
        queue.enqueue("pedro");
        queue.enqueue("kiko");
        System.out.println(queue.toString());

        System.out.println("Front: " + queue.first());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Queue after dequeue:\n" + queue.toString());

        Mensagem mensagem = new Mensagem("Eu sou o melhor");
        mensagem.printMensagem();
        mensagem.codificarMensagem(1003);
        mensagem.printMensagem();
        mensagem.descodificarMensagem();
        mensagem.printMensagem();

    }
}
