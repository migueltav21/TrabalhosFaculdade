package List;

import List.interfaces.OrderedListADT;

public class ArrayOrderesList<T> extends List<T> implements OrderedListADT<T> {

    public ArrayOrderesList() {
        super();
    }

    @Override
    public void add(T object) {
        if (!(object instanceof Comparable)) {
            throw new IllegalArgumentException("Element must implenet Comparable");
        }

        int cont = 0;
        if (!isEmpty()) {
            for (T element : this) {
                if (((Comparable<T>)getMaxValue()).compareTo(object) <= 0) {
                    try {
                        getList()[getSize()] = object;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        T[] newList = extendArray(getList(), 0, 0, super.getList().length);
                        setList(newList);
                        getList()[getSize()] = object;
                    }
                    super.setMaxValue(object);
                    break;
                } else if (((Comparable<T>)getMinValue()).compareTo(object) >= 0) {
                    try {
                        for (int i = getSize()-1; i >= 0; i--) {
                            getList()[i+1] = getList()[i];
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        T[] newList = extendArray(getList(), 0, 0, super.getList().length);
                        setList(newList);
                        for (int i = getSize()-1; i >= 0; i--) {
                            getList()[i+1] = getList()[i];
                        }
                    }
                    getList()[0] = object;
                    setMinValue(object);
                    break;
                } else if (((Comparable<T>)element).compareTo(object) < 0 && ((Comparable<T>)getList()[cont + 1]).compareTo(object) >= 0) {
                    try {
                        for (int i = getSize()-1; i >= cont; i--) {
                            getList()[i+1] = getList()[i];
                        }
                        getList()[cont + 1]  = object;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        T[] newList = extendArray(getList(), 0, 0, cont + 1);
                        newList[cont + 1] = object;
                        System.arraycopy(getList(), cont + 1, newList, cont + 2, getList().length - (cont + 1) );
                        this.setList(newList);
                    }
                    break;
                }
                cont++;
            }
        } else {
            getList()[0] = object;
            setMinValue(object);
            setMaxValue(object);
        }
        setSize(getSize() + 1);
    }
}
