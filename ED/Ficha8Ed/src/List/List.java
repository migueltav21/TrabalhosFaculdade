package List;

import List.interfaces.ListADT;

import java.util.Iterator;

public class List<T> implements ListADT<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_SIZE = 100;
    private T maxValue;
    private T minValue;

    public List() {
        this.size = 0;
        this.list = (T[])(new Object[1]);
    }

    protected T getMaxValue() {
        return maxValue;
    }

    protected void setMaxValue(T maxValue) {
        this.maxValue = maxValue;
    }

    protected T getMinValue() {
        return minValue;
    }

    protected void setMinValue(T minValue) {
        this.minValue = minValue;
    }

    public T[] getList() {
        return list;
    }

    protected void setList(T[] list) {
        this.list = list;
    }

    public int getSize() {
        return size;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    public int getDEFAULT_SIZE() {
        return DEFAULT_SIZE;
    }

    protected T[] extendArray(T[] list, int srcPos, int destPos, int size) {
        T[] newList = (T[])(new Object[getList().length * 2]);
        System.arraycopy(list, srcPos, newList, 0, size);
        return newList;
    }

    @Override
    public T removeFirst() {
        if (!isEmpty()) {
            T element = list[0];

            for(int i = 0; i < size - 1; i++) {
                list[i] = list[i+1];
            }

            list[size - 1] = null;

            this.size--;
            return element;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (!isEmpty()) {
            T element = list[size-1];
            list[size - 1] = null;
            this.size--;
            return element;
        }
        return null;
    }

    private int getObjectPos(T object) {
        int pos = 0;
        for (T element : this) {
            if (element.equals(object)) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

    @Override
    public void remove(T object) {
        if (!isEmpty()) {
            int pos = getObjectPos(object);
            if (pos != -1) {
                for(int i = pos; i < size - 1; i++) {
                    list[i] = list[i+1];
                }
            }
            list[size - 1] = null;
        }
    }

    @Override
    public T first() {
        return list[0];
    }

    @Override
    public T last() {
        return list[size-1];
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
        return new ListIterator(this);
    }

    public class ListIterator implements Iterator<T> {
        private int index;

        public ListIterator(List<T> object) {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < getSize();
        }

        @Override
        public T next() {
            return list[index++];
        }
    }
}
