import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class ex7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner ler = new Scanner(System.in);

        System.out.print("Digite o primeiro valor inteiro:\n ");
        int valor1 = ler.nextInt();

        System.out.print("Digite o segundo valor inteiro:\n ");
        int valor2 = ler.nextInt();

        int resultado = valor1 * (valor2 ^ (-1));

        int resultado2 = Math.floorMod(valor1, valor2);

        System.out.printf("A parte inteira da divisao é: %d\n", resultado);
        System.out.printf("O resto da divisao inteira é: %d\n", resultado2);
        
    }
    
}
