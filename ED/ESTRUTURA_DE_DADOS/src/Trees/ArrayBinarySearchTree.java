package Trees;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinarySearchTreeADT;

/**
 * ArrayBinarySearchTree implements a binary search tree
 * using an array.
 *
 */

public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T>
        implements BinarySearchTreeADT<T> {
    protected int height;
    protected int maxIndex;

    /**
     * Creates an empty binary search tree.
     */
    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    /**
     * Creates a binary search with the specified element as its root
     *
     * @param element the element that will become the root of
     *                the new tree
     */
    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 1;
        maxIndex = 0;
    }

    /**
     * Adds the specified object to this binary search tree in the
     * appropriate position according to its key value. Note that
     * equal elements are added to the right. Also note that the
     * index of the left child of the current index can be found by
     * doubling the current index and adding 1. Finding the index
     * of the right child can be calculated by doubling the current
     * index and adding 2.
     *
     * @param element the element to be added to the search tree
     */
    @Override
    public void addElement(T element) {
        if (tree.length < maxIndex * 2 + 3) {
            expandCapacity();
        }
        Comparable<T> tempelement = (Comparable<T>) element;

        if (isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;
            while (!added) {
                if (tempelement.compareTo((tree[currentIndex])) < 0) {
                    /** go left */
                    if (tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if (currentIndex * 2 + 1 > maxIndex)
                            maxIndex = currentIndex * 2 + 1;
                    } else
                        currentIndex = currentIndex * 2 + 1;
                } else {
                    /** go right */
                    if (tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if (currentIndex * 2 + 2 > maxIndex)
                            maxIndex = currentIndex * 2 + 2;
                    } else
                        currentIndex = currentIndex * 2 + 2;
                }
            }
        }
        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        count++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        boolean found = false;

        if (isEmpty())
            return result;

        for (int i = 0; (i <= maxIndex) && !found; i++) {
            if ((tree[i] != null) && targetElement.equals(tree[i])) {
                found = true;
                result = tree[i];
                replace(i);
                count--;
            }
        }

        if (!found)
            throw new ElementNotFoundException("element not found in the binary tree");

        int temp = maxIndex;
        maxIndex = -1;
        for (int i = 0; i <= temp; i++)
            if (tree[i] != null)
                maxIndex = i;

        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;

        return result;

    } // method removeElement

    @Override
    public void removeAllOccurrences (T targetElement) throws
    ElementNotFoundException 
    {
         removeElement(targetElement);
 
        while (contains(targetElement))
           removeElement(targetElement);
 
    }  // method removeAllOccurrences
 
    @Override
    public T removeMin() throws EmptyCollectionException 
   {

      T result = null;

      if (isEmpty())
           throw new EmptyCollectionException ("binary tree");
      else 
      {
         int currentIndex = 1;
         int previousIndex = 0;
         while (tree[currentIndex] != null && currentIndex <= tree.length) 
         {
            previousIndex = currentIndex;
            currentIndex = currentIndex * 2 + 1;
         } //while
         result = tree[previousIndex] ;
         replace(previousIndex);
      } //else

      count--;

      return result;
   }  // method removeMin

    @Override
    public T removeMax() throws EmptyCollectionException 
    {
       T result = null;
 
       if (isEmpty())
            throw new EmptyCollectionException ("binary tree");
       else 
       {
          int currentIndex = 2;
          int previousIndex = 0;
          while (tree[currentIndex] != null && currentIndex <= maxIndex) 
          {
             previousIndex = currentIndex;
             currentIndex = currentIndex * 2 + 2;
          } //while
          result = tree[previousIndex] ;
          replace(previousIndex);
       } //else
 
       count--;
 
       return result;
    }  // method removeMax
 

    @Override
    public T findMin() throws EmptyCollectionException 
   {
      T result = null;

      if (isEmpty())
           throw new EmptyCollectionException ("binary tree");
      else {
         int currentIndex = 0;
         while ((currentIndex*2+1 <= maxIndex) && (tree[currentIndex*2+1] != null))
            currentIndex = currentIndex*2+1;
         result = tree[currentIndex] ;
      }
      return result;
   }
    @Override
    public T findMax() throws EmptyCollectionException 
    {
       T result = null;
 
       if (isEmpty())
            throw new EmptyCollectionException ("binary tree");
       else {
          int currentIndex = 0;
          while ((currentIndex*2+2 <= maxIndex) && (tree[currentIndex*2+2] != null))
             currentIndex = currentIndex*2+2;
          result = tree[currentIndex] ;
       }
       return result;
    }  

    /**
 * Replaces the element at the specified index with the last element in the tree,
 * then updates the maxIndex accordingly.
 *
 * @param index the index of the element to be replaced
 */
protected void replace(int index) {
    // Find the index of the last element in the tree
    int lastIndex = maxIndex;

    // Replace the element at the specified index with the last element
    tree[index] = tree[lastIndex];

    // Set the last element to null
    tree[lastIndex] = null;

    // Update maxIndex if the removed element was the last element
    if (index == lastIndex) {
        maxIndex--;

        // Update height based on the new maxIndex
        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        return;
    }

    // Update maxIndex if the removed element was not the last element
    if (lastIndex % 2 == 0) {
        // The last element was a right child, so check the left child
        if (tree[index * 2 + 1] != null) {
            maxIndex = Math.max(maxIndex, index * 2 + 1);
        } else {
            // The left child is null, so update maxIndex based on the parent
            maxIndex = index * 2;
        }
    } else {
        // The last element was a left child, so check the right child
        if (tree[index * 2 + 2] != null) {
            maxIndex = Math.max(maxIndex, index * 2 + 2);
        } else {
            // The right child is null, so update maxIndex based on the parent
            maxIndex = (index - 1) / 2;
        }
    }

    // Update height based on the new maxIndex
    height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
}

}