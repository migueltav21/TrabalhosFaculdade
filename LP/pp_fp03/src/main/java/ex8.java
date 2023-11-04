
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
public class ex8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Valor em euros:\n");
        float valor = input.nextFloat();
        int moeda2 = 0, moeda1 = 0, moeda50 = 0, moeda20 = 0, moeda10 = 0, moeda5 = 0, moeda02 = 0, moeda01 = 0;
        
        
        while(valor > 0){
            if(valor >= 2){
                valor -= 2;
                  moeda2 ++;
            }else if(valor >= 1){
                valor -= 1;
                moeda1++;
            }else if(valor < 1 && valor >= 0.50){
                valor -= 0.50;
                moeda50++;
            }else if(valor < 0.50 && valor >= 0.20){
                valor -= 0.20;
                       moeda20++;
            }else if(valor < 0.2 && valor >= 0.10){
                valor -= 0.10;
                moeda10++;
            }else if(valor < 0.10 && valor >= 0.05){
                valor -= 0.05;
                moeda5++;
            }else if(valor< 0.05 && valor >= 0.02){
                valor -= 0.02;
                moeda02++;
            }else{
                valor -= 0.01;
                moeda01++;
            }
        }
       
        
        if (moeda2 > 0) {
            System.out.printf("%d moedas de 2 euros\n", moeda2);
        }
        if (moeda1 > 0) {
            System.out.printf("%d moedas de 1 euro\n", moeda1);
        }
        if (moeda50 > 0) {
            System.out.printf("%d moedas de 50 centimos\n", moeda50);
        }
        if (moeda20 > 0) {
            System.out.printf("%d moedas de 20 centimos\n", moeda20);
        }
        if (moeda10 > 0) {
            System.out.printf("%d moedas de 10 centimos\n", moeda10);
        }
        if (moeda5 > 0) {
            System.out.printf("%d moedas de 5 centimos\n", moeda5);
        }
        if (moeda02 > 0) {
            System.out.printf("%d moedas de 2 centimos\n", moeda02);
        }
        if (moeda01 > 0) {
            System.out.printf("%d moedas de 1 centimos\n", moeda01);
        }
    
        
        
    }

}
