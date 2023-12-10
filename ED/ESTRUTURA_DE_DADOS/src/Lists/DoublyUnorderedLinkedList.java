package Lists;

import java.util.NoSuchElementException;

import Interfaces.UnorderedListADT;
import Nodes.DoubleNode;

public class DoublyUnorderedLinkedList<T> extends DoublyLinkedList<T> implements UnorderedListADT<T> {

    public DoublyUnorderedLinkedList() {
        super();
    }

    @Override
    public void addToFront(T element) {
        DoubleNode<T> novo = new DoubleNode<>(element);
        if (getSize() == 0) {
            setFront(novo);
            setRear(novo);
        } else {
            novo.setNext(getFront());
            getFront().setPrevious(novo);
            setFront(novo);
        }
        setSize(getSize() + 1);
        setModCount(getModCount() + 1);
    }
    

    @Override
    public void addToRear(T element) {
        DoubleNode<T> novo = new DoubleNode<>(element);
        if (getSize() == 0) {
            setFront(novo);
            setRear(novo);
        } else {
            getRear().setNext(novo);
            novo.setPrevious(getRear());
            setRear(novo);
        }
        setSize(getSize() + 1);
        setModCount(getModCount() + 1);
    }
    

    @Override
    public void addAfter(T element, T target) {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia");
        }
    
        DoubleNode<T> current = getFront();
        do {
            if (target.equals(current.getData())) {
                DoubleNode<T> newNode = new DoubleNode<>(element);
                newNode.setPrevious(current);
                newNode.setNext(current.getNext());
    
                current.getNext().setPrevious(newNode);
                current.setNext(newNode);
    
                // Se o alvo é o último nó, ajuste o rear
                if (current == getRear()) {
                    setRear(newNode);
                }
    
                setSize(getSize() + 1);
                setModCount(getModCount() + 1);
                return;
            }
            current = current.getNext();
        } while (current != getFront());
    
        throw new NoSuchElementException("O elemento de destino não foi encontrado na lista");
    }
    

}
