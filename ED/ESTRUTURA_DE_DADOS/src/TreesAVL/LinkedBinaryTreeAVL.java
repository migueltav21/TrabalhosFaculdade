package TreesAVL;

import java.util.Iterator;

import Exceptions.ElementNotFoundException;
import Interfaces.BinaryTreeADT;
import Lists.DoublyUnorderedLinkedList;
import Queues.LinkedQueue;

/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 *
 */
public class LinkedBinaryTreeAVL<T> implements BinaryTreeADT<T> {
    protected int count;
    protected AVLTreeNode<T> root;  // Alteração aqui

    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTreeAVL() {
        count = 0;
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the
     *                new binary tree
     */
    public LinkedBinaryTreeAVL(T element) {
        count = 1;
        root = new AVLTreeNode<T>(element);  // Alteração aqui
    }

    @Override
    public T getRoot() {
        return root.element;
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
     * @param targetElement the element being sought in this tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if an element not found
     *                                  exception occurs
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        AVLTreeNode<T> current = findAgain(targetElement, root);

        if (current == null)
            throw new ElementNotFoundException("binary tree");

        return (current.element);
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next          the element to begin searching from
     */
    private AVLTreeNode<T> findAgain(T targetElement, AVLTreeNode<T> next) {  // Alteração aqui
        if (next == null)
            return null;

        if (next.element.equals(targetElement))
            return next;

        AVLTreeNode<T> temp = findAgain(targetElement, next.left);

        if (temp == null)
            temp = findAgain(targetElement, next.right);

        return temp;
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with
     * the root.
     *
     * @return an in order iterator over this binary tree
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        DoublyUnorderedLinkedList<T> tempList = new DoublyUnorderedLinkedList<T>();
        inorder(root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node     the node to be used as the root
     *                 for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inorder(AVLTreeNode<T> node,  // Alteração aqui
            DoublyUnorderedLinkedList<T> tempList) {
        if (node != null) {
            inorder(node.left, tempList);
            tempList.addToRear(node.element);
            inorder(node.right, tempList);
        }
    }

  
    @Override
    public Iterator<T> iteratorPreOrder() {
        DoublyUnorderedLinkedList<T> tempList = new DoublyUnorderedLinkedList<T>();
        preOrder(root, tempList);

        return tempList.iterator();
    }

    protected void preOrder(AVLTreeNode<T> node,
            DoublyUnorderedLinkedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.element);
            preOrder(node.left, tempList);
            preOrder(node.right, tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        DoublyUnorderedLinkedList<T> tempList = new DoublyUnorderedLinkedList<T>();
        postOrder(root, tempList);

        return tempList.iterator();
    }

    protected void postOrder(AVLTreeNode<T> node,
            DoublyUnorderedLinkedList<T> tempList) {
        if (node != null) {
            postOrder(node.left, tempList);
            postOrder(node.right, tempList);
            tempList.addToRear(node.element);
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        DoublyUnorderedLinkedList<T> tempList = new DoublyUnorderedLinkedList<T>();
        levelOrder(root, tempList);

        return tempList.iterator();
    }

    protected void levelOrder(AVLTreeNode<T> node, DoublyUnorderedLinkedList<T> tempList) {
        LinkedQueue<AVLTreeNode<T>> queue = new LinkedQueue<>();
        if (node != null) {
            queue.enqueue(node);
        }
        while (!queue.isEmpty()) {
            AVLTreeNode<T> head = queue.dequeue();
            tempList.addToRear(head.element);

            if (head.left != null) {
                queue.enqueue(head.left);
            }

            if (head.right != null) {
                queue.enqueue(head.right);
            }
        }
    }
}
