package List;

import List.interfaces.OrderedListADT;

import java.util.Iterator;

public class DoubleLinkedOrderedList<T extends Comparable<T>> implements OrderedListADT<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoubleLinkedOrderedList() {
        size = 0;
        head = new Node<T>(null);
        tail = new Node<T>(null);
        tail.setNext(head);
        head.setPrevius(tail);
    }

    private Node<T> getHead() {
        return head;
    }

    private void setHead(Node<T> head) {
        this.head = head;
    }

    private Node<T> getTail() {
        return tail;
    }

    private void setTail(Node<T> tail) {
        this.tail = tail;
    }

    private int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    @Override
    public T removeFirst() {
        T element = head.getPrevius().getData();
        head.getPrevius().getPrevius().setNext(head);
        head.setPrevius(head.getPrevius().getPrevius());

        size--;

        return element;
    }

    @Override
    public T removeLast() {
        T element = tail.getNext().getData();
        tail.setNext(tail.getNext().getNext());
        tail.getNext().getNext().setPrevius(tail);

        size--;

        return element;
    }

    @Override
    public void remove(T object) {
        Node<T> pointer = tail.getNext();
        while(!pointer.equals(head)) {

            if (pointer.getData().compareTo(object) == 0) {
                pointer.getPrevius().setNext(pointer.getNext());
                pointer.getNext().setPrevius(pointer.getPrevius());
                size--;
            }

            pointer = pointer.getNext();
        }
    }

    @Override
    public T first() {
        return head.getPrevius().getData();
    }

    @Override
    public T last() {
        return tail.getNext().getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    @Override
    public void add(T object) {
        Node<T> newNode = new Node<>(object);

        if (isEmpty()) {
            head.setPrevius(newNode);
            tail.setNext(newNode);

            newNode.setPrevius(tail);
            newNode.setNext(head);
        } else {
            if (object.compareTo(tail.getNext().getData()) <= 0) {
                tail.getNext().setPrevius(newNode);

                newNode.setNext(tail.getNext());
                newNode.setPrevius(tail);

                tail.setNext(newNode);
            } else if (object.compareTo(head.getPrevius().getData()) >= 0) {
                head.getPrevius().setNext(newNode);

                newNode.setNext(head);
                newNode.setPrevius(head.getPrevius());

                head.setPrevius(newNode);
            } else {
                Node<T> pointer = tail.getNext();
                while(!pointer.equals(head)) {
                    if (pointer.getData().compareTo(object) < 0 && pointer.getNext().getData().compareTo(object) >= 0) {
                        newNode.setNext(pointer.getNext());
                        newNode.setPrevius(pointer);

                        pointer.getNext().setPrevius(newNode);
                        pointer.setNext(newNode);

                        break;
                    }
                    pointer = pointer.getNext();
                }
            }
        }
        size++;
    }

    public class ListIterator implements Iterator<T> {
        private Node<T> head, tail, pointer;

        public ListIterator(DoubleLinkedOrderedList<T> object) {
            head = object.getHead();
            tail = object.getTail();
            pointer = head.getPrevius();
        }

        @Override
        public boolean hasNext() {
            return !(pointer.getPrevius().equals(tail));
        }

        @Override
        public T next() {
            T element = pointer.getData();
            pointer = pointer.getPrevius();
            return element;
        }
    }
}
