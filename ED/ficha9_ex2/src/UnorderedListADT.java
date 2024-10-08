public interface UnorderedListADT<T> extends ListADT<T> {
    /**
     * 12. * Adds the specified element to this list at
     * 13. * the proper location
     * 14. *
     * 15. * @param element the element to be added to this list
     * 16.
     */
    void addToFront(T element);

    void addToRear(T element);

    void addAfter(T element, T target);
}