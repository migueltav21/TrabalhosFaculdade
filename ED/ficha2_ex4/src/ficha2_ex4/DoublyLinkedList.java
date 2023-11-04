/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha2_ex4;


/**
 *
 * @author Rui Tavares
 */
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
        } else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
            tamanho++;
        }
        tamanho++;
    }
    
        public void adicionarFim(T elemento) {
        No<T> novo = new No<>(elemento);
        if (tamanho == 0) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProximo(null);
            fim.setProximo(novo);
            fim = novo;
            tamanho++;
        }
        tamanho++;
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

    public Object[] arrayComTodosElementos() {
        Object[] array = new Object[tamanho];
        int contador = 0;
        No<T> current = inicio;
        while (current != null) {
            array[contador] = current.getElemento();
            current = current.getProximo();
            contador++;
        }
        return array;
    }

    public Object[] arrayAtePosicao(int num) {
        if (num < 0 || tamanho - num < 0) {
            throw new IndexOutOfBoundsException("Posicao fora dos limites da lista.");
        } else {
            Object[] array = new Object[num + 1];
            No<T> current = inicio;
            int aux = 0;
            while (current != null && aux <= num) {
                array[aux] = current.getElemento();
                current = current.getProximo();
                aux++;
            }
            return array;
        }
    }

    public Object[] arrayDesdePosicao(int num) {
        if (num < 0 || tamanho - num < 0) {
            throw new IndexOutOfBoundsException("Posicao fora dos limites da lista.");
        } else {
            Object[] array = new Object[tamanho - num - 1];
            No<T> current = fim;
            int aux = 0;
            while (current != null && num >= aux) {
                array[aux] = current.getElemento();
                current = current.getAnterior();
                aux++;
            }
            return array;
        }
    }

    public Object[] arrayIntervaloPosicao(int strart, int end) {
        if (strart < 0 || end <= strart || strart > end) {
            throw new IndexOutOfBoundsException("Posicao fora dos limites da lista.");
        }
        int numArray = end - strart + 1;
        Object[] array = new Object[numArray];
        No<T> current = inicio;
        int aux = 0;
        while (current != null && aux < strart) {
            current = current.getProximo();
            aux++;
        }

        aux = 0;
        while (current != null && aux < end) {
            array[aux] = current.getElemento();
            current = current.getProximo();
            aux++;
        }
        return array;

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

    public DoublyLinkedList<T> linkedlist() {
        DoublyLinkedList<T> list = new DoublyLinkedList<>();
        No<T> current = inicio;

        if (current == null) {
            System.out.println("Lista vazia");
            return list;
        } else {
            if (!(current.getElemento() instanceof Integer)) {
                System.out.println("Lista nao e constituida por numeros inteiros");
                return list;
            } else {
                while (current != null) {
                    if ((int) current.getElemento() % 2 == 0) {
                        list.adicionarInicio(current.getElemento());
                    }
                    current = current.getProximo();
                }
                return list;
            }
        }
    }

    public void elementosIguias(T elemento) {
        int num = 0;
        int aux = 0;
        No<T> current = inicio;
        while (current != null) {
            if (current.getElemento() == elemento) {
                num++;
            }
            current = current.getProximo();
        }
        current = inicio;
        while (current != null) {
            if (current.getElemento() == elemento) {
                aux++;
                if (aux > 1) {
                    if (current == fim) {
                        fim = fim.getAnterior();
                        fim.setProximo(null);
                    } else if (current == inicio) {
                        inicio = inicio.getProximo();
                        inicio.setAnterior(null);
                    } else {
                        No<T> anterior = current.getAnterior();
                        No<T> proximo = current.getProximo();
                        anterior.setProximo(proximo);
                        proximo.setAnterior(anterior);
                    }
                    tamanho--;
                }
            }
            current = current.getProximo();
        }

        System.out.println("Existem " + num + " vezes o elemento " + elemento + " presente na lista");
    }
}
