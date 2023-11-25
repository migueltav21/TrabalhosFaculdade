public class OrderedList<T> extends List<T> implements OrderedListADT<T> {

    public OrderedList(){
        super();
    }
    
    @Override
    public void add(T element) {
        if (!(element instanceof Comparable)) {
            throw new IllegalArgumentException("Element must implement Comparable");
        }
    
        No<T> newNode = new No<>(element);
        if (isEmpty()) {
            setFront(newNode);
            setRear(newNode);
        } else if (((Comparable<T>) element).compareTo(super.getFront().getElemento()) <= 0) {
            newNode.setProximo(super.getFront());
            getFront().setAnterior(newNode);
            setFront(newNode);
        } else if (((Comparable<T>) element).compareTo(getRear().getElemento()) >= 0) {
            newNode.setAnterior(super.getRear());
            newNode.setProximo(null);  // Remova esta linha
            super.getRear().setProximo(newNode);
            super.setRear(newNode);
        } else {
            No<T> current = getFront();
            while (current != null && ((Comparable<T>) element).compareTo(current.getElemento()) > 0) {
                current = current.getProximo();
            }
            newNode.setAnterior(current.getAnterior());
            newNode.setProximo(current);
            current.getAnterior().setProximo(newNode);
            current.setAnterior(newNode);
        }
        setSize(getSize() + 1);
        setModCount(getModCount() + 1);
    }
    

}
