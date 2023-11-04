package pp_fp09.programming;

import java.util.Arrays;

public class GestorProjeto extends Pessoa {

    private int codigoFuncionario;
    private String[] projetos;
    private int anosTrabalho;

    public GestorProjeto(int codigoFuncionario, int anosTrabalho, String nome, String dataNascimento, String morada, int numCC, int nif, float salarioBase) {
        super(nome, dataNascimento, morada, numCC, nif, salarioBase);
        this.codigoFuncionario = codigoFuncionario;
        this.anosTrabalho = anosTrabalho;
        this.projetos = new String[0];
        super.setSalarioBase(salariofinal(salarioBase));
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String[] getProjetos() {
        return projetos;
    }

    public void setProjetos(String[] projetos) {
        this.projetos = projetos;
    }

    public void adicionarProjeto(String projeto) {
        String[] array = new String[this.getProjetos().length + 1];
        if (this.getProjetos().length != 0) {
            for (int i = 0; i < this.getProjetos().length; i++) {
                array[i] = this.getProjetos()[i];
            }
        }
        array[array.length - 1] = projeto;
        this.setProjetos(array);
        this.setSalarioBase(this.getSalarioBase() + this.getSalarioBase() * 0.01f);
    }

    public int getAnosTrabalho() {
        return anosTrabalho;
    }

    public void setAnosTrabalho(int anosTrabalho) {
        this.anosTrabalho = anosTrabalho;
    }

    @Override
    public String toString() {
        return "nome=" + this.getNome()
                + ", dataNascimento=" + this.getDataNascimento()
                + ", morada=" + this.getMorada()
                + ", numCC=" + this.getNumCC() + ", nif=" + this.getNif()
                + ", salarioBase=" + this.getSalarioBase() + ", codigoFuncionario=" + codigoFuncionario
                + ", dataContratacao=" + anosTrabalho + " ,Projetos=" + Arrays.toString(this.getProjetos());
    }

    @Override
    public float salariofinal(float salario) {
        float total = salario * 1.15f;
        total += salario * this.getAnosTrabalho() * 0.015f;
        if (this.getProjetos() != null) {
            total += salario * 0.01 * this.getProjetos().length;
        }
        return total;
    }
}
