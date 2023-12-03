package Stacks;
import Nodes.Node;

public class LinkedStack<T> implements StackADT<T> {
    private final String EMPTY_ERROR = "This stack is empty";
    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }


    @Override
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException(EMPTY_ERROR);
        }
        T removed = top.getData();
        top = top.getNext();
        size--;
        return removed;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException(EMPTY_ERROR);
        }
        return top.getData();
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
    public String toString() {
        if (isEmpty()) {
            throw new IllegalStateException(EMPTY_ERROR);
        }
        StringBuilder sb = new StringBuilder();
        Node<T> current = top;
        sb.append("Stack:\n");
        while (current != null) {
            sb.append(current.getData());
            if(current.getNext() != null){
                sb.append("\n");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
}