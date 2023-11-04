package pp_fp07.publicSchool;

import java.util.*;

public class Aluno extends Pessoa{
   private String CodigoAluno;
   private ArrayList<UnidadeCurricular> unidadesC = new ArrayList<>();

    public Aluno(String CodigoAluno, ArrayList array, String nome, String dataNascimento, String Morada, int numCC, int numIF) {
        super(nome, dataNascimento, Morada, numCC, numIF);
        this.CodigoAluno = nome;
        this.unidadesC = array;
    }

    public String getNomeAluno() {
        return CodigoAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.CodigoAluno = nomeAluno;
    }

    public ArrayList<UnidadeCurricular> getUnidadesC() {
        return unidadesC;
    }

    public void setUnidadesC(ArrayList<UnidadeCurricular> unidadesC) {
        this.unidadesC = unidadesC;
    }

     public void addUnidadesCurriculares(UnidadeCurricular unidadeCurricular) {
        this.unidadesC.add(unidadeCurricular);
    }

    public void removeUnidadesCurricules(UnidadeCurricular unidadeCurricular) {
        this.unidadesC.remove(unidadeCurricular);
    }
    
    @Override
    public String toString() {
        return "Aluno:" + "Nome=" + this.getNome() + ", dataNascimento=" + this.getDataNascimento() + ", Morada=" + this.getMorada() + ", numCC=" + this.getNumCC() + ", numIF=" + this.getNumIF() + "nomeAluno=" + CodigoAluno + ", unidadesC=" + unidadesC + '}';
    }
   
   
}
