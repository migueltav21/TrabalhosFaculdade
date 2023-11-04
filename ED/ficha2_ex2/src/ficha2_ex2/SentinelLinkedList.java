/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha2_ex2;

/**
 *
 * @author Rui Tavares
 */
public class SentinelLinkedList<T> {
    private No sentinela;
    private int tamanho;

    public SentinelLinkedList() {
       sentinela = new No(null);
        this.tamanho = 0;
    }
    
public void add(T elemento) {
        No<T> novoNo = new No<>(elemento);
        novoNo.setProximo(sentinela.getProximo());
        sentinela.setProximo(novoNo);
        tamanho++;
    }
    
    public void remove(T elemento) {
        No<T> atual = sentinela;
        while (atual.getProximo() != null) {
            No<T> proximo = atual.getProximo();
            if (proximo.getElemento() != null && proximo.getElemento().equals(elemento)) {
                atual.setProximo(proximo.getProximo());
                tamanho--;
                return;
            }
            atual = proximo;
        }
    }

    @Override
    public String toString() {
        return "SentinelLinkedList{" + "sentinela=" + sentinela + '}';
    }
    
    public void printList() {
        No current = sentinela.getProximo();
        while (current != null) {
            System.out.print(current.getElemento().toString() + " -> ");
            current = current.getProximo();
        }
        System.out.println("null");
    }

    
}
