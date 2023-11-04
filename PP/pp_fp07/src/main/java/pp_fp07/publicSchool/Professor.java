package pp_fp07.publicSchool; 
import java.util.*;
import pp_fp07.publicSchool.Enums.*;

public class Professor extends Pessoa{
    private String sigla;
    private TipoContrato tipoContrato;
    private ArrayList<UnidadeCurricular> unidadesCurriculares = new ArrayList<>();

    public Professor(String sigla, TipoContrato tipoContrato, ArrayList array, String nome, String dataNascimento, String Morada, int numCC, int numIF) {
        super(nome, dataNascimento, Morada, numCC, numIF);
        this.sigla = sigla;
        this.tipoContrato = tipoContrato;
        this.unidadesCurriculares = array;
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

    public ArrayList<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadesCurriculares;
    }

    public void setUnidadesCurriculares(ArrayList<UnidadeCurricular> unidadesCurriculares) {
        this.unidadesCurriculares = unidadesCurriculares;
    }

      public void addUnidadesCurriculares(UnidadeCurricular unidadeCurricular) {
        this.unidadesCurriculares.add(unidadeCurricular);
    }

    public void removeUnidadesCurricules(UnidadeCurricular unidadeCurricular) {
        this.unidadesCurriculares.remove(unidadeCurricular);
    }
    
    
    @Override
    public String toString() {
        return "Professor: " + "Nome=" + this.getNome() + ", dataNascimento=" + this.getDataNascimento() + ", Morada=" + this.getMorada() + ", numCC=" + this.getNumCC() + ", numIF=" + this.getNumIF() + "sigla=" + sigla + ", tipoContrato=" + tipoContrato + ", unidadesCurriculares=" + unidadesCurriculares;
    }
    
    
}
