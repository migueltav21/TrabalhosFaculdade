
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
public class ex6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* Scanner input = new Scanner(System.in);
        System.out.print("Valor em centimos:\n");
        int valor = input.nextInt();
        int euros, centimos;
        euros = valor / 100;
        centimos = valor % 100;
        System.out.printf("%d centimos são %d euros e %d centimos", valor, euros, centimos);
        */
      
        int[] listaA = {2, -5, -121, 102, -35, -2, 0, -125, 802, -10};
        int[] listaB = {6, 99, -1, 12, 1, -2, -121};

        int total = listaB.length + listaA.length;
        int cont = listaA.length;
        int contRepVetor = 0, tamanhoRepetidos = 0, tamanhoVetorSim = 0;
        boolean nalista;

        int[] vetor = new int[total];
        int[] repetidos = new int[total / 2];
        int[] vetorSim = new int[listaB.length];

        // Juntar ambos os vetores num so

        System.arraycopy(listaA, 0, vetor, 0, listaA.length);

        for (int k : listaB) {
            vetor[cont++] = k;
        }

        for (int j : vetor) {
            System.out.printf("%d ", j);
        }

        // Contar quantos elementos repetido existem em listaA

        for (int pos = 0; pos < vetor.length; pos++) {
            nalista = false;
            for (int num : repetidos) {
                if (vetor[pos] == num) {
                    nalista = true;
                    break;
                }
            }
            if (!nalista) {
                for (int pos2 = 0; pos2 < vetor.length; pos2++) {
                    if (pos != pos2 && vetor[pos] == vetor[pos2]) {
                        contRepVetor++;
                        repetidos[tamanhoRepetidos++] = vetor[pos];
                        break;
                    }
                }
            }
        }

        System.out.printf("\nExistem %d numeros repetidos nas listas\n", contRepVetor);

        // Criar um vetor com os elementos simultaneos nos 2 vetores
        /*
        Nota: nao podemos usar o vetor "Repetidos" ja existente pois esse ira guardar numeros repetidos na mesma lista,
        coisa que nos nao queremos.
         */

        for (int num : listaB) {
            nalista = false;
            for (int num2: listaA) {
                if (num == num2) {
                    for (int num3 : vetorSim) {
                        if (num == num3) {
                            nalista = true;
                            break;
                        }
                    }
                    if (!nalista) {
                        vetorSim[tamanhoVetorSim++] = num;
                    }
                }
            }
        }

        for (int i = 0; i < tamanhoVetorSim; i++) {
            System.out.printf("%d ", vetorSim[i]);
        }
    }
}
