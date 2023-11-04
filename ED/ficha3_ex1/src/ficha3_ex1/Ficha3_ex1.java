/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficha3_ex1;

/**
 *
 * @author Rui Tavares
 */
public class Ficha3_ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>(3);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        stack.push("Miguel");
        stack.push("Joao");
        stack.push("Pedro");
        stack.push("Sandra");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.toString());
        
        PostfixCalculator calculadora = new PostfixCalculator();
       float num = calculadora.conta("7 4 -3 * 5 1 + / *");
       System.out.println(num);
    }
}
