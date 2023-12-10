package Trees;

import java.util.Iterator;

import Exceptions.ElementNotFoundException;
import Interfaces.BinaryTreeADT;
import Lists.ArrayUnorderedList;
import Lists.DoublyUnorderedLinkedList;
import Queues.CircularArrayQueue;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {
    private final int CAPACITY = 50;
    protected int count;
    protected T[] tree;

    /**
     * Creates an empty binary tree.
     */
    public ArrayBinaryTree() {
        count = 0;
        tree = (T[]) new Object[CAPACITY];
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element which will become the root
     *                of the new tree
     */
    public ArrayBinaryTree(T element) {
        count = 1;
        tree = (T[]) new Object[CAPACITY];
        tree[0] = element;
    }


    protected void expandCapacity()
   {
      T[] temp = (T[]) new Object[tree.length * 2];
      for (int ct=0; ct < tree.length; ct++)
         temp[ct] = tree[ct];
      tree = temp;
   }

   
    @Override
    public T getRoot() {
        return tree[0];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(T elementoAlvo) {
        try {
            find(elementoAlvo);
            return true; // Se encontrar, retorna true
        } catch (ElementNotFoundException e) {
            return false; // Se não encontrar, retorna false
        }
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree. Throws a NoSuchElementException if
     * the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in the tree
     * @return true if the element is in the tree
     * @throws ElementNotFoundException if an element not found
     *                                  exception occurs
     */
    public T find(T targetElement) throws ElementNotFoundException {
        T temp = null;
        boolean found = false;

        for (int ct = 0; ct < count && !found; ct++)
            if (targetElement.equals(tree[ct])) {
                found = true;
                temp = tree[ct];
            }
        if (!found)
            throw new ElementNotFoundException("binary tree");
        return temp;
    }

    /**
     * Performs an inorder traversal on this binary tree by
     * calling an overloaded, recursive inorder method
     * that starts with the root.
     *
     * @return an iterator over the binary tree
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        DoublyUnorderedLinkedList<T> templist = new DoublyUnorderedLinkedList<T>();
        inorder(0, templist);
        return templist.iterator();
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node     the node used in the traversal
     * @param templist the temporary list used in the traversal
     */
    protected void inorder(int node, DoublyUnorderedLinkedList<T> templist) {
        if (node < tree.length)
            if (tree[node] != null) {
                inorder(node * 2 + 1, templist);
                templist.addToRear(tree[node]);
                inorder((node + 1) * 2, templist);
            }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        DoublyUnorderedLinkedList<T> templist = new DoublyUnorderedLinkedList<T>();
        preorder(0, templist);
        return templist.iterator();
    }

    protected void preorder(int node, DoublyUnorderedLinkedList<T> templist) {
        if (node < tree.length)
            if (tree[node] != null) {
                templist.addToRear(tree[node]);
                preorder(node * 2 + 1, templist);
                preorder((node + 1) * 2, templist);
            }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        DoublyUnorderedLinkedList<T> templist = new DoublyUnorderedLinkedList<T>();
        postorder(0, templist);
        return templist.iterator();
    }

    protected void postorder(int node, DoublyUnorderedLinkedList<T> templist) {
        if (node < tree.length)
            if (tree[node] != null) {
                postorder(node * 2 + 1, templist);
                postorder((node + 1) * 2, templist);
                templist.addToRear(tree[node]);
            }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        DoublyUnorderedLinkedList<T> templist = new DoublyUnorderedLinkedList<T>();
        levelOrder(0, templist);
        return templist.iterator();
    }

    protected void levelOrder(int node, DoublyUnorderedLinkedList<T> tempList) {
        CircularArrayQueue<T> queue = new CircularArrayQueue<>();
        if (tree[node] != null) {
            queue.enqueue(tree[node]);
        }
        while (!queue.isEmpty()) {
            T head = queue.dequeue();
            int currentIndex = indexOf(head);
            tempList.addToRear(head);

            int leftChildIndex = currentIndex * 2 + 1;
            if (leftChildIndex < count && tree[leftChildIndex] != null) {
                queue.enqueue(tree[leftChildIndex]);
            }

            int rightChildIndex = (currentIndex + 1) * 2;
            if (rightChildIndex < count && tree[rightChildIndex] != null) {
                queue.enqueue(tree[rightChildIndex]);
            }
        }
    }

    public int indexOf(T element) throws ElementNotFoundException{
        int temp = 0;
        boolean found = false;

        for (int ct = 0; ct < count && !found; ct++)
            if (element.equals(tree[ct])) {
                found = true;
                temp = ct;
            }
        if (!found)
            throw new ElementNotFoundException("That element does not exist");
        return temp;
    }

}
