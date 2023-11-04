/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrizT = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d |", matriz[i][j]);
            }
            System.out.print("\n");
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrizT[i][j] = matriz[j][i];
            }
        }
        
         System.out.print("\n");
        
       for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d |", matrizT[i][j]);
            }
            System.out.print("\n");
        } 
    }

}
