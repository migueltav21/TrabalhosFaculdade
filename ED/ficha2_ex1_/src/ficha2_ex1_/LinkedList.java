/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha2_ex1_;

/**
 *
 * @author Rui Tavares
 */
public class LinkedList<T> {

    private No inicio;
    private No ultimo;
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public void add(T elemento) {
        No celula = new No(elemento);
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
            No atual = inicio;
            No anterior = null;
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
        No current = inicio;
        while (current != null) {
            System.out.print(current.getElemento().toString() + " -> ");
            current = current.getProximo();
        }
        System.out.println("null");
    }

}
