import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class List<T> implements ListADT<T> {
    private No<T> front;
    private No<T> rear;
    private int size;
    private int modCount;

    public List() {
        front = new No<>(null);
        rear = new No<>(null);
        front.setProximo(rear);
        rear.setAnterior(front);
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
        T elemento = front.getElemento();
        if (size == 1) {
            front = null;
            rear = null;
            size--;
        } else {
            front = front.getProximo();
            front.setAnterior(rear);
            size--;
        }
        modCount++;
        return elemento;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia");
        }
        T elemento = rear.getElemento();
        if (size == 1) {
            front = null;
            rear = null;
            size--;
        } else {
            rear = rear.getAnterior();
            rear.setProximo(front);
            size--;
        }
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

        No<T> current = front;
        while (current != null) {
            if (current.getElemento().equals(element)) {
                if (current == front) {
                    return removeFirst();
                } else if (current == rear) {
                    return removeLast();
                } else {
                    current.getAnterior().setProximo(current.getProximo());
                    current.getProximo().setAnterior(current.getAnterior());
                    size--;
                    modCount++;
                    return current.getElemento();
                }
            }
            current = current.getProximo();
        }

        return null;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia");
        }
        return front.getElemento();
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia");
        }
        return rear.getElemento();
    }

    @Override
    public boolean contains(T target) {
        No<T> elemento = front;
        do {
            if (elemento.getElemento().equals(target)) {
                return true;
            }
            elemento = elemento.getProximo();
        }while(elemento != front);
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
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        No<T> current = front;
        do {
            sb.append(current.getElemento());
            if (current.getProximo() != front) {
                sb.append(", ");
            }
            current = current.getProximo();
        } while (current != front);

        sb.append("]");
        return sb.toString();
    }

    private class OrderedListIterator implements Iterator<T> {
        private No<T> current = front;
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
            T element = current.getElemento();
            current = current.getProximo();
            remainingElements--;
            return element;
        }
    }

    public No<T> getFront() {
        return front;
    }

    public void setFront(No<T> front) {
        this.front = front;
    }

    public No<T> getRear() {
        return rear;
    }

    public void setRear(No<T> rear) {
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
