package pp_fp09.programming;

public class ProgrammingManagement {

    private Pessoa[] empresa;

    public ProgrammingManagement(Pessoa[] empresa) {
        this.empresa = empresa;
    }

    public Pessoa[] getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Pessoa[] empresa) {
        this.empresa = empresa;
    }

    public void listarFuncionarios() {
        System.out.println("EMPRESA:");
        for (Pessoa pessoa : this.empresa) {
            System.out.println(pessoa.toString());
            System.out.println("----------------------");
        }
    }
    
    public void adicionarFuncionario(Pessoa p){
        Pessoa[] novoArray = new Pessoa[this.empresa.length+1];
        for(int i = 0; i < this.empresa.length; i++){
            novoArray[i] = this.getEmpresa()[i];
        }
        novoArray[novoArray.length - 1] = p;
        this.setEmpresa(novoArray);
    }
    
    public void removerFuncionario(Pessoa p){
        int num = -1;
        for(int i = 0; i < this.empresa.length; i++){
            if(p == this.empresa[i]){
                num = i;
            }
        }
        if(num == -1){
            System.out.println("Não é possível remover essa pessoa visto que não trabalha na empresa");
        }else{
            Pessoa[] novoArray = new Pessoa[this.empresa.length-1];
             for(int i = 0; i < num; i++){
                 novoArray[i] = this.getEmpresa()[i];
             }
             for(int i = num; i< this.empresa.length - 1; i++){
                 novoArray[i] = this.getEmpresa()[i + 1];
             }
             this.setEmpresa(novoArray);
        }
    }
}
