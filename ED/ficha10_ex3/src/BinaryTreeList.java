import java.util.Iterator;

public abstract class BinaryTreeList<T> implements ListADT<T> {
    protected int count;
    protected BinaryTreeNode<T> root;

    public BinaryTreeList() {
        count = 0;
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the
     *                new binary tree
     */
    public BinaryTreeList(T element) {
        count = 1;
        root = new BinaryTreeNode<T>(element);
    }

    @Override
    public T removeFirst() {
        T first = first();
        if (first != null) {
            remove(first);
        }
        return first;
    }

    @Override
    public T removeLast() {
        T last = last();
        if (last != null) {
            remove(last);
        }
        return last;
    }

    @Override
    public T remove(T targetElement)
            throws ElementNotFoundException {
        T result = null;
        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.element)) {
                result = root.element;
                root = replacement(root);
                count--;
            }

            else {
                BinaryTreeNode<T> current, parent = root;
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

    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;
        if ((node.left == null) && (node.right == null))
            result = null;
        else if ((node.left != null) && (node.right == null))
            result = node.left;
        else if ((node.left == null) && (node.right != null))
            result = node.right;

        else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
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
        }
        return result;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            // Trate o caso em que a lista está vazia
            return null; // ou lance uma exceção, dependendo dos requisitos
        }
    
        BinaryTreeNode<T> current = root;
        while (current.left != null) {
            current = current.left;
        }
    
        return current.element;
    }

    @Override
    public T last() {
        if (isEmpty()) {
            // Trate o caso em que a lista está vazia
            return null; // ou lance uma exceção, dependendo dos requisitos
        }
    
        BinaryTreeNode<T> current = root;
        while (current.right != null) {
            current = current.right;
        }
    
        return current.element;
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

    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);

        if (current == null)
            throw new ElementNotFoundException("binary tree");

        return (current.element);
    }

    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
        if (next == null)
            return null;

        if (next.element.equals(targetElement))
            return next;

        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);

        if (temp == null)
            temp = findAgain(targetElement, next.right);

        return temp;
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
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

}
