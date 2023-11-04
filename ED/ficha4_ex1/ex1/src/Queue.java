import java.util.NoSuchElementException;


public class Queue<T> implements QueueADT<T> {
    private No<T> front;
    private No<T> rear;
    int tamanho;

    public Queue() {
        front = null;
        rear = null;
        tamanho = 0;
    }

    @Override
    public void enqueue(T element) {
        No<T> newNode = new No<>(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setProximo(newNode);
            rear = newNode;
        }
        tamanho++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T elemento = front.getElemento();
        front = front.getProximo();
        tamanho--;

        if (isEmpty()) {
            rear = null;
        }

        return elemento;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.getElemento();
    }

    @Override
    public boolean isEmpty() {
        return (tamanho == 0);
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
   public String toString() {
        StringBuilder sb = new StringBuilder();
        No<T> current = front;
        while (current != null) {
            sb.append(current.getElemento()).append(" ");
            current = current.getProximo();
        }
        return sb.toString();
    }
}
