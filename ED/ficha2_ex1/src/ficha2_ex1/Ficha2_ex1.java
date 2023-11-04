/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficha2_ex1;

/**
 *
 * @author Rui Tavares
 */
public class Ficha2_ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Pessoa("Alice"));
        list.add(new Pessoa("Bob"));
        list.add(new Pessoa("Charlie"));

        System.out.println("Lista Inicial:");
        list.printList();

        list.remove("Bob");
        System.out.println("Lista apos remover a pessoa Bob:");
        list.printList();
    }
    
}
