/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficha2_ex1_;

/**
 *
 * @author Rui Tavares
 */
public class Ficha2_ex1_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(4);
        lista.add(33);
        lista.remove(4);
        System.out.println(lista.toString());
        System.out.println(lista.getTamanho());
        lista.printList();
    }
    
}
