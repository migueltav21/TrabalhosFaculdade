package TreesAVL;

public class AVLTreeNode<T> {
    T element;
    AVLTreeNode<T> left;
    AVLTreeNode<T> right;
    int height;

    public AVLTreeNode(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
        this.height = 1; // Inicializamos a altura como 1 para o novo nó
    }

    public int numChildren() {
        int children = 0;
        if (left != null)
            children = 1 + left.numChildren();
        if (right != null)
            children = children + 1 + right.numChildren();
        return children;
    }
}