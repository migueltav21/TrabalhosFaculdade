/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class Two {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] matriz = {11, 7, 333,
            -20, -23, 63,
            -22, 501, 10000};

        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i]);
            System.out.print('|');
            if (i == 2) {
                System.out.print("\n");
            }
            if (i == 5) {
                System.out.print("\n");
            }
        }

        float media = 0, soma = 0;
System.out.print("\n");
        for (int i = 0; i < matriz.length; i++) {
            soma = soma + matriz[i];
        }
media = soma / matriz.length;
System.out.println(soma);
System.out.println(media);
        
    }
}
