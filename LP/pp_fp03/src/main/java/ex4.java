
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
public class ex4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Valor em graus:");
        float grau = input.nextFloat();
        double radianos = grau * (Math.PI / 180);
        System.out.printf("O valor de %.2fº é de %.2f radianos", grau, radianos);

    }

}
