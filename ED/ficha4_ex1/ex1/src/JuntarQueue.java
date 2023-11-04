public class JuntarQueue<T> {
    Queue<T> queue;

    JuntarQueue() {
        queue = new Queue<>();
    }

    public void juntar_queue(Queue<T> a, Queue<T> b) {
        while (!a.isEmpty()) {
            queue.enqueue(a.dequeue());
        }
        while (!b.isEmpty()) {
            queue.enqueue(b.dequeue());
        }
    }

    public void printQueuesJuntas(){
        if(!queue.isEmpty()){
        System.out.println(queue.toString());
        }else{
            System.out.println("Qeue esta vazia");
        }
    }
}
