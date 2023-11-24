package List.interfaces;

public interface UnorderedListADT<T> extends ListADT<T>{
    void addToFront(T object);
    void addToRear(T object);
    void addAfter(T target, T object);
}
