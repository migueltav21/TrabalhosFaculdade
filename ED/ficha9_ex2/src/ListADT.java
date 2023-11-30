import java.util.Iterator;

public interface ListADT<T> extends Iterable<T> {
    /**
     * 5. * Removes and returns the first element from this list.
     * 6. *
     * 7. * @return the first element from this list
     */
    T removeFirst();

    /**
     * 10. * Removes and returns the last element from this list.
     * 11. *
     * 12. * @return the last element from this list
     * 13.
     */
    T removeLast();

    /**
     * 16. * Removes and returns the specified element from this list.
     * 17. *
     * 18. * @param element the element to be removed from the list
     * 19.
     */
    T remove(T element);

    /**
     * 22. * Returns a reference to the first element in this list.
     * 23. * @return a reference to the first element in this list
     * 24.
     */
    T first();

    /**
     * 27. * Returns a reference to the last element in this list.
     * 28. * @return a reference to the last element in this list
     * 29.
     */
    T last();

    /**
     * 32. * Returns true if this list contains the specified target
     * 33. * element.
     * 34. * @param target the target that is being sought in the list
     * 35. * @return true if the list contains this element
     * 36.
     */
    boolean contains(T target);

    /**
     * 7
     * 39. * Returns true if this list contains no elements.
     * 40. * @return true if this list contains no elements
     * 41.
     */
    boolean isEmpty();

    /**
     * 44. * Returns the number of elements in this list.
     * 45. *
     * 46. * @return the integer representation of number of
     * 47. * elements in this list
     * 48.
     */
    int size();

    /**
     * 51. * Returns an iterator for the elements in this list.
     * 52. *
     * 53. * @return an iterator over the elements in this list
     * 54.
     */
    Iterator<T> iterator();

    /**
     * 57. * Returns a string representation of this list.
     * 58. *
     * 59. * @return a string representation of this list
     * 60.
     */
    @Override
    String toString();
}