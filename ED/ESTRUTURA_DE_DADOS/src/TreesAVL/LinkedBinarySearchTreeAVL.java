package TreesAVL;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinarySearchTreeADT;

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

    public void addElement(T element) {
        AVLTreeNode<T> temp = new AVLTreeNode<T>(element);

        if (isEmpty()) {
            root = temp;
        } else {
            root = addElement(root, temp);
        }

        count++;
    }

    private AVLTreeNode<T> addElement(AVLTreeNode<T> currentNode, AVLTreeNode<T> newNode) {
        Comparable<T> element = (Comparable<T>) newNode.element;

        if (element.compareTo(currentNode.element) < 0) {
            if (currentNode.left == null) {
                currentNode.left = newNode;
            } else {
                currentNode.left = addElement(currentNode.left, newNode);
            }
        } else {
            if (currentNode.right == null) {
                currentNode.right = newNode;
            } else {
                currentNode.right = addElement(currentNode.right, newNode);
            }
        }

        // Atualizar altura e rebalancear durante a subida na recursão
        updateHeight(currentNode);
        return rebalance(currentNode);
    }

    public T removeElement(T targetElement)
            throws ElementNotFoundException {
        T result = null;
        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.element)) {
                result = root.element;
                root = replacement(root);
                count--;
                root = rebalance(root);
                updateHeight(root);
            }

            else {
                AVLTreeNode<T> current, parent = root;
                boolean found = false;
                if (((Comparable) targetElement).compareTo(root.element) < 0)
                    current = root.left;
                else
                    current = root.right;
                while (current != null && !found) {
                    if (targetElement.equals(current.element)) {
                        found = true;
                        count--;
                        result = current.element;
                        if (current == parent.left) {
                            parent.left = replacement(current);
                        }

                        else {
                            parent.right = replacement(current);
                        }
                        root = rebalance(root);
                        updateHeight(root);
                    } else {
                        parent = current;
                        if (((Comparable) targetElement).compareTo(current.element) < 0)
                            current = current.left;
                        else
                            current = current.right;
                    }
                } // while
                if (!found)
                    throw new ElementNotFoundException("binary search tree");
            }
        } // end outer if
        return result;
    }

    /**
     * Returns a reference to a node that will replace the one
     * specified for removal. In the case where the removed node has
     * two children, the inorder successor is used as its replacement.
     *
     * @param node the node to be removeed
     * @return a reference to the replacing node
     */
    protected AVLTreeNode<T> replacement(AVLTreeNode<T> node) {
        AVLTreeNode<T> result = null;
        if ((node.left == null) && (node.right == null))
            result = null;
        else if ((node.left != null) && (node.right == null))
            result = node.left;
        else if ((node.left == null) && (node.right != null))
            result = node.right;

        else {
            AVLTreeNode<T> current = node.right;
            AVLTreeNode<T> parent = node;
            while (current.left != null) {
                parent = current;
                current = current.left;
            }
            if (node.right == current)
                current.left = node.left;
            else {
                parent.left = current.right;
                current.right = node.right;
                current.left = node.left;
            }
            result = current;
            result = rebalance(result);
            updateHeight(root);
        }
        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        try {
            while (contains((T) targetElement))
                removeElement(targetElement);
        } catch (Exception ElementNotFoundException) {
        }
    }

    @Override
    public T removeMin() {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary tree");
        else {
            if (root.left == null) {
                result = root.element;
                root = root.right;
                root = rebalance(root); // Rebalance a árvore após a remoção
                updateHeight(root);
            } else {
                AVLTreeNode<T> parent = root;
                AVLTreeNode<T> current = root.left;
                while (current.left != null) {
                    parent = current;
                    current = current.left;
                }
                result = current.element;
                parent.left = current.right;
                root = rebalance(root);
                updateHeight(root);
            }

            count--;
        } // else

        return result;
    }

    @Override
    public T removeMax() {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary tree");
        else {
            if (root.right == null) {
                result = root.element;
                root = root.left;
                root = rebalance(root); // Rebalance a árvore após a remoção
                updateHeight(root);
            } // if
            else {
                AVLTreeNode<T> parent = root;
                AVLTreeNode<T> current = root.right;

                while (current.right != null) {
                    parent = current;
                    current = current.right;
                } // while

                result = current.element;
                parent.right = current.left;
                root = rebalance(root); // Rebalance a árvore após a remoção
                updateHeight(root);
            } // else

            count--;
        } // else

        return result;
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

    private int height(AVLTreeNode<T> node) {
        if (node != null) {
            return node.height;
        } else {
            return -1;
        }
    }

    private void updateHeight(AVLTreeNode<T> node) {
        int leftChildHeight = height(node.left);
        int rightChildHeight = height(node.right);
        node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    private int balanceFactor(AVLTreeNode<T> node) {
        return height(node.right) - height(node.left);
    }

    private AVLTreeNode<T> rotateRight(AVLTreeNode<T> node) {
        AVLTreeNode<T> leftChild = node.left;

        node.left = leftChild.right;
        leftChild.right = node;

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    private AVLTreeNode<T> rotateLeft(AVLTreeNode<T> node) {
        AVLTreeNode<T> rightChild = node.right;

        node.right = rightChild.left;
        rightChild.left = node;

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    private AVLTreeNode<T> rebalance(AVLTreeNode<T> node) {
        int balanceFactor = balanceFactor(node);

        // Left-heavy?
        if (balanceFactor < -1) {
            if (height(node.left.right) > height(node.left.left)) {
                // Rotate left-right
                node.left = rotateLeft(node.left);
            }
            // Rotate right
            node = rotateRight(node);
        }
        // Right-heavy?
        else if (balanceFactor > 1) {
            if (height(node.right.left) > height(node.right.right)) {
                // Rotate right-left
                node.right = rotateRight(node.right);
            }
            // Rotate left
            node = rotateLeft(node);
        }

        return node;
    }

}
