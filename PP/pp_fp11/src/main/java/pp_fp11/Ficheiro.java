package pp_fp11;

import pp_fp11.Enums.*;

public class Ficheiro {
    private String nome;
    private Extensao extensao;
    private int tamanho;
    private int duracao;

    public Ficheiro(String nome, Extensao extensao, int tamanho, int duracao) {
        this.nome = nome;
        this.extensao = extensao;
        this.tamanho = tamanho;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Extensao getExtensao() {
        return extensao;
    }

    public void setExtensao(Extensao extensao) {
        this.extensao = extensao;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    
}