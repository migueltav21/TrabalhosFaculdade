/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp_fp04.book;

import java.util.Scanner;

/**
 *
 * @author joao
 */
public class Book {

    protected String titulo;
    protected String editor;
    protected Authors[] autores = new Authors[2];
    protected int ano;
    protected int paginas;
    protected int[] avalicao = new int[3];

    int avaliacao() {
        Scanner input = new Scanner(System.in);
        int avaliacao = 0;
        while (avaliacao < 1 || avaliacao > 10) {
            System.out.println("Avaliação:");
            avaliacao = input.nextInt();
        }
        return avaliacao;
    }
}
