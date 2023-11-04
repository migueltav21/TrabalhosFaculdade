/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficha2_ex4;


/**
 *
 * @author Rui Tavares
 */
public class Ficha2_ex4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.adicionarInicio(10);
        lista.adicionarInicio(20);
        lista.adicionarInicio(2);
        lista.adicionarInicio(33);
        lista.adicionarInicio(7);
        lista.adicionarInicio(7);
        lista.adicionarInicio(7);

        DoublyLinkedList<String> lista2 = new DoublyLinkedList<>();
        lista2.adicionarInicio("Miguel");

        //lista.removerPrimeiroElemento();
        //lista.removerUltimoElemento();
        lista.printList();
        Object[] array = lista.arrayComTodosElementos();

        for (Object elemento : array) {
            if (elemento != null) {
                System.out.println(elemento);
            }
        }

        System.out.println("-----------------------");

        Object[] array2 = lista.arrayAtePosicao(3);
        for (Object elemento : array2) {
            if (elemento != null) {
                System.out.println(elemento);
            }
        }

        System.out.println("-----------------------");

        try {
            Object[] array3 = lista.arrayDesdePosicao(2);

            System.out.println("Elementos na Lista Ligada desde a posicao " + 2 + ":");

            for (Object elemento : array3) {
                if (elemento != null) {
                    System.out.println(elemento);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------------");

        try {
            Object[] array4 = lista.arrayIntervaloPosicao(1, 3);

            for (Object elemento : array4) {
                if (elemento != null) {
                    System.out.println(elemento);
                }
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------------");
        DoublyLinkedList<Integer> listapares = lista.linkedlist();
        listapares.printList();

        System.out.println("-----------------------");
        lista.elementosIguias(7);
        lista.printList();
    }
}
