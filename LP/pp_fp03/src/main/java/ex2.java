/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vetor = {2, 5, 6, 3, 7, 13, 17, 21, 32, 45, 28, 496};
        int auxiliar = 0;
        System.out.println("Os números primos são o seguintes:");

        for (int i = 0; i < vetor.length; i++) {
            for (int j = 1; j <= vetor[i]; j++) {
                if (vetor[i] % j == 0) {
                    auxiliar++;
                }
            }
            if(auxiliar == 2){
                System.out.println(vetor[i]);
            }
            auxiliar =0;
        }

         System.out.println("Os números perfeitos são o seguintes:");
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 1; j < vetor[i]; j++) {
                if(vetor[i] % j == 0){
                    soma += j;
                }
            }
            if(soma == vetor[i]){
                System.out.println(vetor[i]);
            }
            soma=0;
        }
        
        
        
        
    }
}
