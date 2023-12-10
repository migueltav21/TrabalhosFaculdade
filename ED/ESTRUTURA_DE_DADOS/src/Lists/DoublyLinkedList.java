package Lists;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import Interfaces.ListADT;
import Nodes.DoubleNode;

public abstract class DoublyLinkedList<T> implements ListADT<T> {
    private DoubleNode<T> front;
    private DoubleNode<T> rear;
    private int size;
    private int modCount;

    public DoublyLinkedList() {
        front = new DoubleNode<>(null);
        rear = new DoubleNode<>(null);
        size = 0;
        modCount = 0;
    }

    public int getModCount() {
        return modCount;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia");
        }

        T elemento = front.getData();

        if (size == 1) {
            front = null;
            rear = null;
        } else {
            front = front.getNext();
            front.setPrevious(null); // Remova a referência ao anterior
        }

        size--;
        modCount++;
        return elemento;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia");
        }

        T elemento = rear.getData();

        if (size == 1) {
            front = null;
            rear = null;
        } else {
            rear = rear.getPrevious();
            rear.setNext(null); // Remova a referência ao próximo
        }

        size--;
        modCount++;
        return elemento;
    }

    @Override
    public T remove(T element) {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia");
        }
        if (!contains(element)) {
            throw new NoSuchElementException("A lista não contém esse elemento");
        }

        DoubleNode<T> current = front;
        while (current != null) {
            if (current.getData().equals(element)) {
                if (current == front) {
                    return removeFirst();
                } else if (current == rear) {
                    return removeLast();
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    size--;
                    modCount++;
                    return current.getData();
                }
            }
            current = current.getNext();
        }

        return null;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia");
        }
        return front.getData();
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia");
        }
        return rear.getData();
    }

    @Override
    public boolean contains(T target) {
        DoubleNode<T> current = front;
        while (current != null) {
            if (current.getData().equals(target)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
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
    public Iterator<T> iterator() {
        return new OrderedListIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleNode<T> current = front;

        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append("\n");
            }
            current = current.getNext();
        }

        return sb.toString();
    }

    private class OrderedListIterator implements Iterator<T> {
        private DoubleNode<T> current = front;
        private int remainingElements = size;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return remainingElements > 0;
        }

        @Override
        public T next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("A lista foi modificada durante a iteração");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("Não há mais elementos na lista");
            }

            T element = current.getData();
            current = current.getNext();

            // Verifica se chegou ao final da lista e reinicia do início se for uma lista
            // não circular
            if (current == null) {
                current = front;
            }

            remainingElements--;
            return element;
        }
    }

    public DoubleNode<T> getFront() {
        return front;
    }

    public void setFront(DoubleNode<T> front) {
        this.front = front;
    }

    public DoubleNode<T> getRear() {
        return rear;
    }

    public void setRear(DoubleNode<T> rear) {
        this.rear = rear;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setModCount(int modCount) {
        this.modCount = modCount;
    }
}
