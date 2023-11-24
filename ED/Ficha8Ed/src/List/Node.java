package List;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> previus;

    public Node(T element) {
        next = previus = null;
        data = element;
    }

    public T getData() {
        return data;
    }

    protected void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    protected void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevius() {
        return previus;
    }

    protected void setPrevius(Node<T> previus) {
        this.previus = previus;
    }
}
