/**
 *
 * @author Rui Tavares
 */
public class LinkedList<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public void add(T elemento) {
        No<T> celula = new No<>(elemento);
        if (tamanho == 0) {
            this.inicio = celula;
            this.ultimo = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    public void remove(T elemento) {
        if (tamanho == 0) {
            return;
        } else if (elemento == inicio.getElemento()) {
            inicio = inicio.getProximo();
            tamanho--;

        } else {
            No<T> atual = inicio;
            No<T> anterior = null;
            while (atual != null && (atual.getElemento() != elemento)) {
                anterior = atual;
                atual = atual.getProximo();
            }
            if (atual != null) {
                anterior.setProximo(atual.getProximo());
                tamanho--;
            }
            if (atual == ultimo) {
                ultimo = anterior;
                tamanho--;
            }
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" + "inicio=" + inicio + '}';
    }

    public void printList() {
        No<T> current = inicio;
        while (current != null) {
            System.out.print(current.getElemento().toString() + " -> ");
            current = current.getProximo();
        }
        System.out.println("null");
    }

    public void printListRecursiva() {
        listRecursiva(inicio);
    }

    private void listRecursiva(No<T> current) {
        if (current == null) {
            System.out.println("Fim da lista");
        } else {
            System.out.print(current.getElemento() + " -> ");
            listRecursiva(current.getProximo());
        }
    }

    public void replace(T existingElement, T newElement) {
        repalceExitingElement(inicio, existingElement, newElement);
    }

    private void repalceExitingElement(No<T> current, T exixtingElement, T newElement) {
        if (current != null) {
            if (current.getElemento().equals(exixtingElement)) {
                current.setElemento(newElement);
            }
            repalceExitingElement(current.getProximo(), exixtingElement, newElement);
        }
    }


    public LinkedList<T> reversedList(){
        LinkedList<T> reversedList = new LinkedList<>();
        return invertOrder(inicio, reversedList);
    }

    private LinkedList<T> invertOrder(No<T> current, LinkedList<T> lista) {
        if (current != null) {
            invertOrder(current.getProximo(), lista);
            lista.add(current.getElemento());
        }
        return lista;
    }
}
