public class Node<T>{
    private Node<T> next;
    private T data;

    public Node(){
    }

    public Node(T element){
        data = element;
        next = null;
    }

    public Node(Node<T> node){
        data = null;
        next = node;
    }

    public Node(T element, Node<T> node){
        data = element;
        next = node;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }


}