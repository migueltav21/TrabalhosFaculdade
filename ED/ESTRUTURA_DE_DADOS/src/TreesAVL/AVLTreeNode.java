package TreesAVL;

public class AVLTreeNode<T> {
    protected T element;
    protected AVLTreeNode<T> left;
    protected AVLTreeNode<T> right;
    protected int height;

    public AVLTreeNode(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
        this.height = 0; // Inicializamos a altura como 0 para o novo nó
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