package pp_fp07.publicSchool;

import java.util.*;

public class SchoolManagement {
    private ArrayList<Pessoa> gestaoPessoas = new ArrayList<>();

    public ArrayList<Pessoa> getGestaoPessoas() {
        return gestaoPessoas;
    }

    public void setGestaoPessoas(ArrayList<Pessoa> gestaoPessoas) {
        this.gestaoPessoas = gestaoPessoas;
    }

public void aadicionarPessoa(Pessoa pessoa){
    this.gestaoPessoas.add(pessoa);
}
    
public void removerPessoa(Pessoa pessoa){
    this.gestaoPessoas.remove(pessoa);
}

  public void listarProfessores() {
        for (Pessoa pessoa : this.gestaoPessoas) {
            if (pessoa instanceof Professor) {
                System.out.printf(((Professor)pessoa).toString());
            }
        }
    }
  
  public void listarAlunosFuncionarios() {
        for (Pessoa pessoa : this.gestaoPessoas) {
            if (!(pessoa instanceof Professor)) {
                if (pessoa instanceof Aluno) {
                    System.out.printf(((Aluno)pessoa).toString());
                } else {
                    System.out.printf(((Funcionario)pessoa).toString());
                }
            }
        }
    }
}
