public class Stack<T> implements StackADT<T> {

    private No<T> head;
    private int count;

    public Stack() {
        head = null;
        count = 0;
    }


    @Override
    public void push(T element) {
        No<T> newNode = new No<>(element);

        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.setProximo(head);
            head = newNode;
        }

        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("Empty stack");
            return null;
        }
        T result = head.getElemento();
        head = head.getProximo();
        count--;
        return result;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.getElemento();
    }

    @Override
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        No<T> current = head;

        while (current != null) {
            sb.append("[").append(current.getElemento()).append("]\n");
            current = current.getProximo();
        }

        return sb.toString();
    }
}
