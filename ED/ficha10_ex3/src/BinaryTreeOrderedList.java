import java.util.Iterator;

public class BinaryTreeOrderedList<T> extends LinkedBinarySearchTree<T> implements ListADT<T>, OrderedListADT<T>
{

   //================================================================
   //  Creates an empty BinarySearchTreeList.
   //================================================================
   public BinaryTreeOrderedList() 
   {
      super();
   }  // constructor BinarSearchTreeList


   //================================================================
   //  adds the given element to the BinarySearchTreeList
   //================================================================
public void add (T element)
   {
      addElement(element);
   }  // method add

//================================================================
//  Removes and returns the first element from this list
//================================================================

   public T removeFirst ()
   {
      return removeMin();
   }

//================================================================
//  Removes and returns the last element from this list
//================================================================
   public T removeLast ()
   {
      return removeMax();
   }

//================================================================
//  Removes and returns the specified element from this list
//================================================================
   public T remove (T element)
   {
      return removeElement(element);
   }

//================================================================
//  Returns a reference to the first element on this list
//================================================================
   public T first ()
   {
      return findMin();
   }

//================================================================
//  Returns a reference to the last element on this list
//================================================================
   public T last ()
   {
      return findMax();
   }

//================================================================
//  Returns an iterator for the list
//================================================================
   public Iterator<T> iterator()
   {
      return iteratorInOrder();
   }



}  // class BinarySearchTreeList
