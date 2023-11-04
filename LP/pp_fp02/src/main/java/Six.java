/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class Six {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] listaA = {2, -5, -121, 102, -35, -2, 0, 111, 99, -125, 802, 1000000, -10};
        int[] listaB = {6, 99, -1, 111, 12, 1, -2, -121};
        int num;

        //alinia a
        //Unir os dois vetores num novo vetor.
        num = listaA.length + listaB.length;
        int[] vetor = new int[num];
        for (int i = 0; i < listaA.length; i++) {
            vetor[i] = listaA[i];
        }
        int auxiliar = listaA.length;
        for (int i = 0; i < listaB.length; i++) {
            vetor[auxiliar] = listaB[i];
            auxiliar++;
        }

        //Imprima o vetor resultante
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("%d ", vetor[i]);
        }

        //alinia b
        //Apresente quantos elementos repetidos existem no vetor criado na alínea a;
        int numRepetidos = 0;
        for (int i = 0; i < vetor.length; i++) {
            for (int n = i + 1; n < vetor.length; n++) {
                if (vetor[i] == vetor[n]) {
                    numRepetidos++;
                }
            }
        }

        System.out.println("\nExistem " + numRepetidos + " numeros repetidos no vetor\n");

        //alinia c
        //Preencher um novo vetor com os elementos do vetor: “listaA” que não se encontram no vetor: ”listaB”;
        int[] vetorB = new int[listaA.length - numRepetidos];
        int aux = 0, n = 0;

        for (int i = 0; i < listaA.length; i++) {
            for (int j = 0; j < listaB.length; j++) {
                if (listaA[i] == listaB[j]) {
                    aux++;
                }
            }
            if (aux == 0) {
                vetorB[n] = listaA[i];
                n++;
            }
            aux = 0;
        }

        for (int i = 0; i < vetorB.length; i++) {
            System.out.printf("%d ", vetorB[i]);
        }

        //alinia d
        //Preencher um novo vetor com os elementos que se encontram simultaneamente nos dois vetores (sem repetidos).
        aux = 0;
        int[] vetorC = new int[numRepetidos];
        for (int i = 0; i < listaA.length; i++) {
            for (int j = 0; j < listaB.length; j++) {
                if (listaA[i] == listaB[j]) {
                    vetorC[aux] = listaA[i];
                    aux++;
                }
            }
        }

        System.out.printf("\n");
        for (int i = 0; i < vetorC.length; i++) {
            System.out.printf("%d ", vetorC[i]);
        }

    }
}
