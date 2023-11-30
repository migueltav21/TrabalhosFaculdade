import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class ArrayList<T> implements ListADT<T> {
    private final String EMPTY_ERROR = "This list is empty";
    private T[] array;
    private final int DEFAULT_CAPACITY = 10;
    private int top;
    private int modCount = 0;

    public ArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        top = 0;
    }

    public ArrayList(int arraySize) {
        array = (T[]) new Object[arraySize];
        top = 0;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException(EMPTY_ERROR);
        }

        T removedItem = array[0];

        for (int i = 0; i < top; i++) {
            array[i] = array[i + 1];
        }
        top--;
        modCount++;
        return removedItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException(EMPTY_ERROR);
        }

        T removedItem = array[top - 1];

        array[top - 1] = null;
        top--;
        modCount++;
        return removedItem;
    }

    @Override
    public T remove(T element) {
        int index = indexOf(element);

        if (index == -1) {
            throw new NoSuchElementException("Element not found in the list");
        }

        T removedItem = array[index];

        for (int i = index; i < top - 1; i++) {
            array[i] = array[i + 1];
        }

        array[top - 1] = null;
        top--;
        modCount++;
        return removedItem;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException(EMPTY_ERROR);
        }

        return array[0];
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new IllegalStateException(EMPTY_ERROR);
        }

        return array[top - 1];
    }

    @Override
    public boolean contains(T target) {
        for(int i = 0; i < top; i++){
            if(target.equals(array[i]) && target != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

   @Override
    public Iterator<T> iterator() {
        return new UnorderedArrayListIterator();
    }

    private class UnorderedArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            if (expectedModCount != getModCount()) {
                throw new ConcurrentModificationException("Modification detected");
            }
            return currentIndex < getTop() - 1;
        }

        @Override
        public T next() {
            if (expectedModCount != getModCount()) {
                throw new ConcurrentModificationException("Modification detected");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("There are no more elements on this list");
            }
            return getArray()[currentIndex++];
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty List";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("List: ");
        for (int i = 0; i < top; i++) {
            sb.append(array[i]);
            if (i < top - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private int indexOf(T element) {
        for (int i = 0; i < top; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int getModCount() {
        return modCount;
    }

    public int getTop() {
        return top;
    }

    public int getDEFAULT_CAPACITY() {
        return DEFAULT_CAPACITY;
    }

    public T[] getArray() {
        return array;
    }

    public void setModCount(int modCount) {
        this.modCount = modCount;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setArray(T[] array) {
        this.array = array;
    }
}