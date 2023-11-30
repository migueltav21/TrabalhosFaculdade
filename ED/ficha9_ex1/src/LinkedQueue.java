public class LinkedQueue<T> implements QueueADT<T> {
    private final String EMPTY_ERROR = "This queue is empty";
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedQueue(){
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new IllegalStateException(EMPTY_ERROR);
        }
        T removed = head.getData();
        head = head.getNext();
        size--;
        return removed;
    }

    @Override
    public T first() {
        if(isEmpty()){
            throw new IllegalStateException(EMPTY_ERROR);
        }
        return head.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        if (isEmpty()) {
            throw new IllegalStateException(EMPTY_ERROR);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:\n");
        Node<T> current = head;
        while(current != null){
            sb.append(current.getData());
            if(current.getNext() != null){
                sb.append("\n");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
}