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
public class Autor {
    String tipo;
    String nome;
    int idade;
    String morada;
    int nif;
    int NIB;
    
    public Autor(String tip, String nom, int age, String morad, int NIF, int nib){
        tipo = tip;
        nome = nom;
        idade = age;
        morada = morad;
        nif = NIF;
        NIB = nib;
    }
}
