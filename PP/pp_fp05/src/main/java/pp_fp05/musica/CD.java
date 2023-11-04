/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp_fp05.musica;
/**
 *
 * @author joao
 */
import java.util.Scanner;
public class CD {
    int maxMusicas = 15;
    String nomeBanda;
    String nomeCD;
    int tempoSegundos;
    String dataLancamento;
    String editora;
    Musica[] musica;
    Banda[] banda;
    double price = 0;
    
    
    public CD(String nomeB, String nomeCd, String data, String editor){
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Quantas musicas tem o album?");
        n = input.nextInt();
        
        nomeBanda = nomeB;
        nomeCD = nomeCd;
        dataLancamento = data;
        editora = editor;
        musica = new Musica[n];
        banda = new Banda[5];
    }
    
    //N esta a dar
    /*
    CD(double valor){
        if(valor <0){
           valor = 0;
        }
       price = valor;
    }
    */
    
    public double cdPrice(double valor){
        if(valor <0){
           valor = 0;
        }
        return valor;
    }
    
}
