
public class DoubleNode<T>{
    private DoubleNode<T> next;
    private DoubleNode<T> previous;
    private T data;

    public DoubleNode(){
        data = null;
        next = null;
        previous = null;
    }

    public DoubleNode(T element){
        data = element;
        next = null;
        previous = null;
    }

    public DoubleNode(DoubleNode<T> node1, DoubleNode<T> node2){
        data = null;
        next = node1;
        previous = node2;
    }

    public DoubleNode(T element, DoubleNode<T> node1, DoubleNode<T> node2){
        data = element;
        next = node1;
        previous = node2;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
    
    public T getData() {
        return data;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }
}