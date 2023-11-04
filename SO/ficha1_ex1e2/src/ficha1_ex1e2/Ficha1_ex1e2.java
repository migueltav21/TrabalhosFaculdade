/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficha1_ex1e2;

import java.util.*;

/**
 *
 * @author Rui Tavares
 */
public class Ficha1_ex1e2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);

        System.out.println("\nResultados:");

        double soma = a + b;
        double subtracao = a - b;
        double multiplicacao = a * b;

        // Verifica se o segundo valor é diferente de zero antes de calcular a divisão
        double divisao;
        if (b != 0) {
            divisao = a / b;
        } else {
            System.out.println("Divisão por zero nao e permitida.");
            return; 
        }
        
      
         System.out.println("Soma: " + soma);
        System.out.println("Subtrcaão: " + subtracao);
        System.out.println("Multiplicacao: " + multiplicacao);
        System.out.println("Divisao: " + divisao);
       
        
    } 
}
