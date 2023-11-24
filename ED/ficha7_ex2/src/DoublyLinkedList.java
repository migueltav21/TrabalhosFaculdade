public class DoublyLinkedList<T> {

    private No<T> fim;
    private No<T> inicio;
    private int tamanho;

    public DoublyLinkedList() {
        this.fim = new No<>(null);
        this.inicio = new No<>(null);
        this.tamanho = 0;
    }

    public void adicionarInicio(T elemento) {
        No<T> novo = new No<>(elemento);
        if (tamanho == 0) {
            inicio = novo;
            fim = novo;
            tamanho++;
        } else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
            tamanho++;
        }
    }

    public void adicionarFim(T elemento) {
        No<T> novo = new No<>(elemento);
        if (tamanho == 0) {
            inicio = novo;
            fim = novo;
            tamanho++;
        } else {
            novo.setProximo(null);
            novo.setAnterior(fim);
            fim.setProximo(novo);
            fim = novo;
            tamanho++;
        }
    }

    public void removerPrimeiroElemento() {
        if (tamanho == 1) {
            inicio = null;
            fim = null;
            tamanho--;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
            tamanho--;
        }
    }

    public void removerUltimoElemento() {
        if (tamanho == 1) {
            inicio = null;
            fim = null;
            tamanho--;
        } else {
            fim = fim.getAnterior();
            fim.setProximo(null);
            tamanho--;
        }
    }

    public boolean isEmpty() {
        if (tamanho == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printList() {
        No<T> current = inicio;
        while (current != null) {
            System.out.print(current.getElemento() + " <-> ");
            current = current.getProximo();
        }
        System.out.println("null");
    }

    private void listForStart(No<T> current) {
        if (current != null) {
            System.out.print(current.getElemento() + " -> ");
            listForStart(current.getProximo());
        } else {
            System.out.println("Fim da lista");
        }
    }

    public void printListForStart() {
        listForStart(inicio);
    }

    public void printReversedList() {
        reversedList(inicio);
        System.out.println("Fim da lista reversa");
    }

    private void reversedList(No<T> current) {
        if (current != null) {
            reversedList(current.getProximo());
            System.out.print(current.getElemento() + " -> ");
        }
    }

    private void listaForEnd(No<T> current) {
        if (current != null) {
            System.out.print(current.getElemento() + " -> ");
            listaForEnd(current.getAnterior());
        } else {
            System.out.println("Fim da lista");
        }
    }

    public void printListForEnd() {
        listaForEnd(fim);
    }
}
