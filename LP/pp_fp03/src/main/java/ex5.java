
import java.util.Scanner;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class ex5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int resposta;
        double valor, conversao;
        do {
            System.out.print("Quer o valor em dolares ou euros?\n0 - dolares\n1 - Euros\nOpcao:\n");
            resposta = input.nextInt();
        } while (resposta < 0 || resposta > 1);
        
        System.out.print("Valor:\n");
        valor = input.nextFloat();
        
        
        if(resposta == 0){
            conversao = valor * 0.94;
            System.out.printf("%.2f dolares são %.2f euros", valor, conversao);
        }else{
            conversao = valor * 1.07;
            System.out.printf("%.2f euros são %.2f dolares", valor, conversao);
        }
    }

}
