package pp_fp07.publicSchool;

public class Pessoa {
   private String nome;
   private String dataNascimento;
   private String Morada;
   private int numCC;
   private int numIF;

    public Pessoa(String nome, String dataNascimento, String Morada, int numCC, int numIF) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.Morada = Morada;
        this.numCC = numCC;
        this.numIF = numIF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMorada() {
        return Morada;
    }

    public void setMorada(String Morada) {
        this.Morada = Morada;
    }

    public int getNumCC() {
        return numCC;
    }

    public void setNumCC(int numCC) {
        this.numCC = numCC;
    }

    public int getNumIF() {
        return numIF;
    }

    public void setNumIF(int numIF) {
        this.numIF = numIF;
    }

    @Override
    public String toString() {
        return "Nome=" + nome + ", dataNascimento=" + dataNascimento + ", Morada=" + Morada + ", numCC=" + numCC + ", numIF=" + numIF;
    }
   
   
   
   
}
