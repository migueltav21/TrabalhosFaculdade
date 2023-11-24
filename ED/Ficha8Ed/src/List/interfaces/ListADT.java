package List.interfaces;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T>{
    T removeFirst();
    T removeLast();
    void remove(T object);
    T first();
    T last();
    boolean isEmpty();
    int size();
    Iterator<T> iterator();
}
