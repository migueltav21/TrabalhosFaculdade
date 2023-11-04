/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class Three {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] lista = {12, 5, -21, 10, -345, 22, 50, -125, 80, -1};
        int multiplicacao = 1;
        int num_negativos = 0;
        int maior = lista[0];
        for (int i = 0; i < lista.length; i++) {
            if(lista[i]>maior){
                maior = lista[i];
            }
            if (lista[i] > 0) {
                multiplicacao = multiplicacao * lista[i];
            } else {
                num_negativos++;
            }
        }
        System.out.println(multiplicacao);
        System.out.printf("Existem %d numeros negativos\n", num_negativos);
        System.out.printf("O maior número do array é %d\n", maior);
        
    }

}
