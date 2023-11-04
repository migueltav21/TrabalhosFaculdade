public class App {
    public static void main(String[] args) throws Exception {
     Queue<String> queue = new Queue<>();

     queue.enqueue("miguel");
     queue.enqueue("joao");
     queue.enqueue("pedro");
     queue.enqueue("kiko");
     System.out.println(queue.toString());
     System.out.println(queue.first());
     System.out.println(queue.dequeue());
     System.out.println(queue.first());
     System.out.println(queue.toString());

    }
}
