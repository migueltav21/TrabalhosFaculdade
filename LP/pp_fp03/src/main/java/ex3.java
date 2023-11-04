/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matriz = {{5, 2, 3}, {4, 5, 6}, {5, 8, 1}, {11, 5, 33}};

        System.out.println("Matriz:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d |", matriz[i][j]);
            }
            System.out.print("\n");
        }

        int maiorNumRep = 0, numRepeticoes = 0, num = matriz[0][0], numMiasVezesRep = 0;

        for (int i = 0; i < 4; i++) {
            int maior = matriz[i][0];
            int menor = matriz[i][0];
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                }
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                }

                for (int l = 0; l < 4; l++) {
                    for (int k = 0; k < 3; k++) {
                        if (matriz[i][j] == matriz[l][k]) {
                            numRepeticoes++;
                        }
                        if (numRepeticoes > maiorNumRep) {
                            maiorNumRep = numRepeticoes;
                            numMiasVezesRep = matriz[i][j];
                        }
                    }
                }
numRepeticoes = 0;
            }
            System.out.printf("Maior numero da %d linha:", i + 1);
            System.out.println(maior);
            System.out.printf("Menor numero da %d linha:", i + 1);
            System.out.println(menor);
        }
        System.out.printf("O numero que se repete mais vezes é o %d que se repete %d vezes:", num, maiorNumRep);

    }
}
