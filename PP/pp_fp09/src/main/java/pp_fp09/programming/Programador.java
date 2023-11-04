package pp_fp09.programming;

import pp_fp09.programming.Enums.*;

public class Programador extends Pessoa {

    private int codigoFuncionario;
    private int numAnosProgramacao;
    private String nomeProjeto;
    private TipoProg tipoProgramador;

    public Programador(int codigoFuncionario, int numAnosProgramacao, String nomeProjeto, TipoProg tipoProgramador, String nome, String dataNascimento, String morada, int numCC, int nif, float salarioBase) {
        super(nome, dataNascimento, morada, numCC, nif, salarioBase);
        this.codigoFuncionario = codigoFuncionario;
        this.numAnosProgramacao = numAnosProgramacao;
        this.nomeProjeto = nomeProjeto;
        this.tipoProgramador = tipoProgramador;
        super.setSalarioBase(salariofinal(salarioBase));
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public int getNumAnosProgramacao() {
        return numAnosProgramacao;
    }

    public void setNumAnosProgramacao(int numAnosProgramacao) {
        this.numAnosProgramacao = numAnosProgramacao;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public TipoProg getTipoProgramador() {
        return tipoProgramador;
    }

    public void setTipoProgramador(TipoProg tipoProgramador) {
        this.tipoProgramador = tipoProgramador;
    }

    @Override
    public float salariofinal(float salario) {
        float total;
        total = salario * 1.05f;
        switch (this.tipoProgramador) {
            case JUNIOR:
                total += total * 0.5f;
            case SENIOR:
                total += total * 0.15f;
        }
        total += salario * 0.05f * this.getNumAnosProgramacao();
        return total;
    }

    @Override
    public String toString() {
        return "nome=" + this.getNome()
                + ", dataNascimento=" + this.getDataNascimento()
                + ", morada=" + this.getMorada()
                + ", numCC=" + this.getNumCC() + ", nif=" + this.getNif()
                + ", salarioBase=" + this.getSalarioBase() + " , codigoFuncionario=" + codigoFuncionario + ", numAnosProgramacao=" + numAnosProgramacao + ", nomeProjeto=" + nomeProjeto + ", tipoProgramador=" + tipoProgramador;
    }

}
