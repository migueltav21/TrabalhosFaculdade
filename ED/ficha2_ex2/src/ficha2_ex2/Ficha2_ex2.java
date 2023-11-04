/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficha2_ex2;

/**
 *
 * @author Rui Tavares
 */
public class Ficha2_ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SentinelLinkedList<Integer> lista = new SentinelLinkedList<>();
        lista.add(10);
        lista.add(20);
        lista.add(200);
        lista.remove(20);
        System.out.println(lista.toString());
        lista.printList();
    }
    
}
