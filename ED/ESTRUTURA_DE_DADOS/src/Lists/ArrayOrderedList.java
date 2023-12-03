package Lists;

public class ArrayOrderedList<T extends Comparable<T>> extends ArrayList<T> implements OrderedListADT<T> {

    public ArrayOrderedList() {
        super();
    }

    private void expandCapacity() {
        T[] newArray = (T[]) new Comparable[super.getArray().length * 2];
        System.arraycopy(super.getArray(), 0, newArray, 0, super.getTop());
        super.setArray(newArray);
    }


    @Override
    public void add(T element) {
        if (super.getTop() == super.getArray().length) {
            expandCapacity();
        }

        int index = 0;


        while (index < super.getTop() && element.compareTo(super.getArray()[index]) > 0) {
            index++;
        }

        for (int i = super.getTop(); i > index; i--) {
            super.getArray()[i] = super.getArray()[i - 1];
        }

        super.getArray()[index] = element;
        super.setTop(super.getTop() + 1);
        super.setModCount(super.getModCount() + 1);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}