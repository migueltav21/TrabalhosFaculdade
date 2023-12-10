package Lists;

import Interfaces.OrderedListADT;
import Nodes.DoubleNode;

public class DoublyOrderedLinkedList<T> extends DoublyLinkedList<T> implements OrderedListADT<T> {

    public DoublyOrderedLinkedList(){
        super();
    }
    
    @Override
    public void add(T element) {
        if (!(element instanceof Comparable)) {
            throw new IllegalArgumentException("Element must implement Comparable");
        }
    
        DoubleNode<T> newNode = new DoubleNode<>(element);
        if (isEmpty()) {
            setFront(newNode);
            setRear(newNode);
        } else if (((Comparable<T>) element).compareTo(super.getFront().getData()) <= 0) {
            newNode.setNext(super.getFront());
            getFront().setPrevious(newNode);
            setFront(newNode);
        } else if (((Comparable<T>) element).compareTo(getRear().getData()) >= 0) {
            newNode.setPrevious(super.getRear());
            newNode.setNext(null);  // Remova esta linha
            super.getRear().setNext(newNode);
            super.setRear(newNode);
        } else {
            DoubleNode<T> current = getFront();
            while (current != null && ((Comparable<T>) element).compareTo(current.getData()) > 0) {
                current = current.getNext();
            }
            newNode.setPrevious(current.getPrevious());
            newNode.setNext(current);
            current.getPrevious().setNext(newNode);
            current.setPrevious(newNode);
        }
        setSize(getSize() + 1);
        setModCount(getModCount() + 1);
    }
    

}
