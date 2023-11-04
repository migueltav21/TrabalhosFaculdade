package pp_fp09.programming;

import pp_fp09.programming.Enums.*;

public class Administrativo extends Pessoa {

    private String sigla;
    private TipoContrato tipoContrato;
    private Habilitacoes habilitacoes;
    private String inicioContrato;
    private String fimContrato;

    public Administrativo(String sigla, TipoContrato tipoContrato, Habilitacoes habilitacoes, String inicioContrato, String fimContrato, String nome, String dataNascimento, String morada, int numCC, int nif, float salarioBase) {
        super(nome, dataNascimento, morada, numCC, nif, salarioBase);
        this.sigla = sigla;
        this.tipoContrato = tipoContrato;
        this.habilitacoes = habilitacoes;
        this.inicioContrato = inicioContrato;
        this.setFimContrato(fimContrato);
        super.setSalarioBase(salariofinal(salarioBase));
    }

    public Administrativo(String sigla, TipoContrato tipoContrato, Habilitacoes habilitacoes, String inicioContrato, String nome, String dataNascimento, String morada, int numCC, int nif, float salarioBase) {
        super(nome, dataNascimento, morada, numCC, nif, salarioBase);
        this.sigla = sigla;
        this.tipoContrato = tipoContrato;
        this.habilitacoes = habilitacoes;
        this.inicioContrato = inicioContrato;
        this.fimContrato = "Contrato sem termo";
        super.setSalarioBase(salariofinal(salarioBase));
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Habilitacoes getHabilitacoes() {
        return habilitacoes;
    }

    public void setHabilitacoes(Habilitacoes habilitacoes) {
        this.habilitacoes = habilitacoes;
    }

    public String getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(String inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public String getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(String fimContrato) {
        if (this.getTipoContrato() == TipoContrato.INTEGRAL) {
            this.fimContrato = "contrato sem termo";
        } else {
            this.fimContrato = fimContrato;
        }
    }


    @Override
    public String toString() {
        return "nome=" + this.getNome()
                + ", dataNascimento=" + this.getDataNascimento()
                + ", morada=" + this.getMorada()
                + ", numCC=" + this.getNumCC() + ", nif=" + this.getNif()
                + ", salarioBase=" + this.getSalarioBase() + "sigla=" + sigla
                + ", tipoContrato=" + tipoContrato + ", habilitacoes=" + habilitacoes
                + ", inicioContrato=" + inicioContrato + ", fimContrato=" + fimContrato;
    }

    @Override
    public float salariofinal(float salario) {
        float total;
        if (this.getTipoContrato() == TipoContrato.INTEGRAL) {
            total = (salario * 1.05f);
        } else {
            total = (salario * 1.1f);
        }

        switch (this.habilitacoes){
            case LICENCIATURA: total += (salario * 0.1f);
            break;
            case MESTRADO: total += (salario * 0.2f);
            break;
            case DOUTURAMENTO: total += (salario * 0.3f);
            break;
        }
        
        return total;
    }

}
