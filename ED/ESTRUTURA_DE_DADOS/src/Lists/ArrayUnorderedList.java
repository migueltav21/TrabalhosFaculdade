package Lists;

import java.util.NoSuchElementException;

public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    public ArrayUnorderedList() {
        super();
    }

    private void expandCapacity() {
        T[] newArray = (T[]) new Object[super.getArray().length * 2];
        System.arraycopy(super.getArray(), 0, newArray, 0, super.getTop());
        super.setArray(newArray);
    }

    @Override
    public void addToFront(T element) {
        if (super.getArray().length == super.getTop()) {
            expandCapacity();
        }
        for (int i = super.getTop() + 1; i > 0; i--) {
            super.getArray()[i] = super.getArray()[i - 1];
        }
        super.getArray()[0] = element;
        super.setTop(super.getTop() + 1);
        super.setModCount(super.getModCount() + 1);
    }

    @Override
    public void addToRear(T element) {
        if (super.getArray().length == super.getTop()) {
            expandCapacity();
        }
        super.getArray()[super.getTop()] = element;

        super.setTop(super.getTop() + 1);
        super.setModCount(super.getModCount() + 1);
    }

    @Override
    public void addAfter(T element, T target) {
        if (super.getArray().length == super.getTop()) {
            expandCapacity();
        }

        int index = 0;

        while (index < super.getTop() && !target.equals(super.getArray()[index])) {
            index++;
        }

        if (index == super.getTop()) {
            throw new NoSuchElementException("The target element is not in this list");
        }

        for (int i = super.getTop() - 1; i >= index; i--) {
            super.getArray()[i + 1] = super.getArray()[i];
        }

        super.getArray()[index + 1] = element;

        super.setTop(super.getTop() + 1);
        super.setModCount(super.getModCount() + 1);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}