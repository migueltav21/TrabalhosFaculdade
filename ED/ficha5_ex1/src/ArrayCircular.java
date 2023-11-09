public class ArrayCircular<T> {
    private T[] array;
    private int front;
    private int rear;
    private int size;
    private final int DEFAULT_CAPACITY = 30;

    public ArrayCircular() {
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void expandCapacity() {
        T[] newArray = (T[]) new Comparable[size * 2];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public T getFirstElement() {
        if (size == 0) {
            throw new IllegalStateException("A lista esta vazia");
        }
        return array[front];
    }

    public T getLastElement() {
        if (size == 0) {
            throw new IllegalStateException("A lista esta vazia");
        }
        return array[rear];
    }

    public void setFront(int valor) {
        front = valor;
    }

    public void setRear(int valor) {
        rear = valor;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public T[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int num) {
        size = num;
    }

}
