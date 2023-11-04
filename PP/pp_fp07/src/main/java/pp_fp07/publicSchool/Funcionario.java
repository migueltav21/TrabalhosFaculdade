package pp_fp07.publicSchool;

import pp_fp07.publicSchool.Enums.*;

public class Funcionario extends Pessoa{
    private int codigo;
    private TipoContrato tipoContrato;

    public Funcionario(int codigo, TipoContrato tipoContrato, String nome, String dataNascimento, String Morada, int numCC, int numIF) {
        super(nome, dataNascimento, Morada, numCC, numIF);
        this.codigo = codigo;
        this.tipoContrato = tipoContrato;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    
    
    @Override
    public String toString() {
        return "Funcionario: "  + "Nome=" + this.getNome() + ", dataNascimento=" + this.getDataNascimento() + ", Morada=" + this.getMorada() + ", numCC=" + this.getNumCC() + ", numIF=" + this.getNumIF() + "codigo=" + codigo + ", tipoContrato=" + tipoContrato;
    }
    
    
    
}
