
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
public class Five {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nome:");
        String nome = input.next();
        System.out.println("Apelido:");
        String apelido = input.next();
        System.out.printf("Bem vindo %s,%s", apelido, nome);
        
        
        
        
    }
    
}
