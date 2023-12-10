package TreesAVL;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinarySearchTreeADT;
import Trees.BinaryTreeNode;

public class LinkedBinarySearchTreeAVL<T> extends LinkedBinaryTreeAVL<T> implements BinarySearchTreeADT<T> {

    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTreeAVL() {
        super();
    }

    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will be the root of the new
     *                binary search tree
     */
    public LinkedBinarySearchTreeAVL(T element) {
        super(element);
    }

    @Override
    public void addElement(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addElement'");
    }

    @Override
    public T removeElement(T targetElement) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeElement'");
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAllOccurrences'");
    }

    @Override
    public T removeMin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMin'");
    }

    @Override
    public T removeMax() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMax'");
    }

    @Override
    public T findMin() {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary tree");
        else {
            AVLTreeNode<T> current = root;

            while (current.left != null)
                current = current.left;

            result = current.element;
        } // else

        return result;

    }

    @Override
    public T findMax() {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary tree");
        else {
            AVLTreeNode<T> current = root;

            while (current.right != null)
                current = current.right;

            result = current.element;
        } // else

        return result;
    }

}
