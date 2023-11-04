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
public class Banda {
    String nomeArtista;
    String nacionalidade;
    String dataNascimento;
    
    public Banda(String nome, String pais, String data){
        nomeArtista = nome;
        nacionalidade = pais;
        dataNascimento = data;
    }
}
