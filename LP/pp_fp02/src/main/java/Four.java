/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class Four {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] nome = {'A', 'n', 'a', ' ', 'S', 'a', 'n', 't', 'o', 's', '\n'};
        int numVogais = 0, numConsoantes = 0;
        int n = 0;
        for (int i = 0; i < nome.length; i++) {
            if (nome[i] == ' ') {
                n = i;
            }
        }

        for (int i = n + 1; i < nome.length - 1; i++) {
            System.out.print(nome[i]);
        }
        System.out.print(",");
        for (int i = 0; i < n; i++) {
            System.out.print(nome[i]);
        }

        for (int i = 0; i < nome.length; i++) {
            if (nome[i] == 'a' || nome[i] == 'e' || nome[i] == 'i' || nome[i] == 'o' || nome[i] == 'u' || nome[i] == 'A' || nome[i] == 'E' || nome[i] == 'I' || nome[i] == 'O' || nome[i] == 'U') {
                numVogais++;
            } else if ((nome[i] >= 65 && nome[i] <= 90) || (nome[i] >= 97 && nome[i] <= 122)) {
                numConsoantes++;
            }
        }
        System.out.print("\n");
        System.out.println(numVogais);
        System.out.println(numConsoantes);

    }
}
