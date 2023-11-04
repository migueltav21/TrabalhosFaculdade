package Aula09;

public class Funcionario extends Pessoa {

    private char setor;
    private boolean trabalhando;
    
    public char getSetor() {
        return setor;
    }
    
    public void setSetor(char setor) {
        this.setor = setor;
    }
    
    public boolean isTrabalhando() {
        return trabalhando;
    }
    
    public void setTrabalhando(boolean trabalhando) {
        this.trabalhando = trabalhando;
    }
    
    public void mudarTrabalho() {
        this.setTrabalhando(!this.isTrabalhando());
    }
    
}
