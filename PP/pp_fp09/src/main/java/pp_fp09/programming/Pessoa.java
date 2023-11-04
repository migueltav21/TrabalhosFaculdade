package pp_fp09.programming;

public abstract class Pessoa {
    private String nome;
    private String dataNascimento;
    private String morada;
    private int numCC;
    private int nif;
    private float salarioBase;

    public Pessoa(String nome, String dataNascimento, String morada, int numCC, int nif, float salarioBase) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.morada = morada;
        this.numCC = numCC;
        this.nif = nif;
        this.salarioBase = salarioBase;
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
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNumCC() {
        return numCC;
    }

    public void setNumCC(int numCC) {
        this.numCC = numCC;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    
    public abstract float salariofinal(float salario);
}
