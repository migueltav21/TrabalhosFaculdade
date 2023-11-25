import java.util.NoSuchElementException;

public class UnorderedList<T> extends List<T> implements UnorderedListADT<T> {

    public UnorderedList() {
        super();
    }

    @Override
    public void addToFront(T element) {
        No<T> novo = new No<>(element);
        if (getSize() == 0) {
            setFront(novo);
            setRear(novo);
        } else {
            novo.setProximo(getFront());
            getFront().setAnterior(novo);
            setFront(novo);
        }
        setSize(getSize() + 1);
        setModCount(getModCount() + 1);
    }
    

    @Override
    public void addToRear(T element) {
        No<T> novo = new No<>(element);
        if (getSize() == 0) {
            setFront(novo);
            setRear(novo);
        } else {
            getRear().setProximo(novo);
            novo.setAnterior(getRear());
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
    
        No<T> current = getFront();
        do {
            if (target.equals(current.getElemento())) {
                No<T> newNode = new No<>(element);
                newNode.setAnterior(current);
                newNode.setProximo(current.getProximo());
    
                current.getProximo().setAnterior(newNode);
                current.setProximo(newNode);
    
                // Se o alvo é o último nó, ajuste o rear
                if (current == getRear()) {
                    setRear(newNode);
                }
    
                setSize(getSize() + 1);
                setModCount(getModCount() + 1);
                return;
            }
            current = current.getProximo();
        } while (current != getFront());
    
        throw new NoSuchElementException("O elemento de destino não foi encontrado na lista");
    }
    

}
