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
public class Musica {

    int numeroFaixa;
    String nomeFaixa;
    int duracao;
    String nomeAutor;
    Autor[] autor = new Autor[5];

    public Musica(int num, String nome, int dura) {
        numeroFaixa = num;
        nomeFaixa = nome;
        duracao = dura;
    }
}
