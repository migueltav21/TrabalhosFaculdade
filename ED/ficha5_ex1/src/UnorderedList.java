import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnorderedList<T extends Comparable<T>> implements UnorderedListADT<T> {
    private ArrayCircular<T> array;
    private int modCount = 0;

    public UnorderedList() {
        array = new ArrayCircular<>();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista esta vazia");
        } else {
            T first = array.getFirstElement();
            array.getArray()[array.getFront()] = null;
            array.setFront((array.getFront() + 1) % array.getArray().length);
            array.setSize(array.getSize() - 1);
            modCount++;
            return first;
        }
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista esta vazia");
        } else {
            T last = array.getLastElement();
            array.getArray()[array.getRear()] = null;
            array.setRear((array.getRear() - 1 + array.getArray().length) % array.getArray().length);
            array.setSize(array.getSize() - 1);
            modCount++;
            return last;
        }
    }

    @Override
    public T remove(T element) {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia");
        }
        if (!contains(element)) {
             throw new NoSuchElementException("A lista nao contem esse elemento");
        }
        
        int indexToRemove = 0;
        while (element.compareTo(array.getArray()[indexToRemove]) > 0) {
            indexToRemove++;
        }

        for (int i = indexToRemove; i < array.getSize(); i++) {
            array.getArray()[(i) % array.getArray().length] = array.getArray()[i + 1];
        }

        array.getArray()[array.getRear()] = null;
        array.setRear((array.getRear() - 1 + array.getArray().length) % array.getArray().length);
        array.setSize(array.getSize() - 1);
        modCount++;
        return element;
    }

    @Override
    public T first() {
        return array.getFirstElement();
    }

    @Override
    public T last() {
        return array.getLastElement();
    }

    @Override
    public boolean contains(T target) {
        for (int i = 0; i < array.getSize(); i++) {
            T currentElement = array.getArray()[(array.getFront() + i) % array.getArray().length];
            if (currentElement != null && currentElement.equals(target)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return array.getSize() == 0;
    }

    @Override
    public int size() {
        return array.getSize();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = array.getFront();
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Modificacao detectada");
                }
                return currentIndex != (array.getRear() + 1) % array.getArray().length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the list");
                }
                T element = array.getArray()[currentIndex];
                currentIndex = (currentIndex + 1) % array.getArray().length;
                return element;
            }
        };
    }

    @Override
    public void addToFront(T element) {
        if (array.getSize() == array.getArray().length) {
            array.expandCapacity();
        }
    
        int frontIndex = (array.getFront() - 1 + array.getArray().length) % array.getArray().length;
        array.getArray()[frontIndex] = element;
        array.setFront(frontIndex);
        array.setSize(array.getSize() + 1);
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        if (array.getSize() == array.getArray().length) {
            array.expandCapacity();
        }
    
        int rearIndex = (array.getRear() + 1) % array.getArray().length;
        array.getArray()[rearIndex] = element;
        array.setRear(rearIndex);
        array.setSize(array.getSize() + 1);
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) {
        if (isEmpty()) {
            throw new NoSuchElementException("A lista está vazia");
        }
    
        if (!contains(target)) {
            throw new NoSuchElementException("A lista não contém o elemento alvo");
        }
    
        int indexToInsert = array.getFront();
        for (int i = 0; i < array.getSize(); i++) {
            T currentElement = array.getArray()[indexToInsert];
            if (currentElement.equals(target)) {
                indexToInsert = i;
                break;
            }
            indexToInsert = (indexToInsert + 1) % array.getArray().length;
        }
    
        if (array.getSize() == array.getArray().length) {
            array.expandCapacity();
        }
    
        for (int i = indexToInsert; i < array.getSize(); i++) {
            array.getArray()[(i + 1) % array.getArray().length] = array.getArray()[i];
        }
    
        array.getArray()[indexToInsert] = element;
        array.setRear(array.getRear() + 1);
        array.setSize(array.getSize() + 1);
        modCount++;
    }


    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        int count = 0;
        int index = array.getFront();

        while (count < array.getSize()) {
            sb.append(array.getArray()[index]);
            if (count < array.getSize() - 1) {
                sb.append(", ");
            }
            index = (index + 1) % array.getArray().length;
            count++;
        }

        sb.append("]");

        return sb.toString();
    }
}
