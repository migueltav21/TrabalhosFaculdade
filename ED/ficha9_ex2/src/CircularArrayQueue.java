import java.util.NoSuchElementException;

public class CircularArrayQueue<T> implements QueueADT<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private final int DEFAULT_CAPACITY = 30;

    public CircularArrayQueue() {
        queue = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    public CircularArrayQueue(int num) {
        queue = (T[]) new Object[num];
        front = 0;
        rear = 0;
        size = 0;
    }

    private void expandCapacity() {
        T[] newQueue = (T[]) new Object[size * 2];

        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[i];
        }

        queue = newQueue;

    }

    @Override
    public void enqueue(T element) {
        if (size == queue.length) {
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T elemento = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return elemento;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = front;
        for (int i = 0; i < size; i++) {
            sb.append(queue[index]).append(" ");
            index = (index + 1) % queue.length;
        }
        return sb.toString();
    }
}
