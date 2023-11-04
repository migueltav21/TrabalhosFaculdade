package Aula09;

public class NewMain {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        Funcionario p2 = new Funcionario();
        Aluno p3 = new Aluno();
        Professor p4 = new Professor();
        
        p1.setNome("Miguel");
        p2.setNome("Maria");
        p3.setNome("Tiago");
        p4.setNome("Luís");
        
        p1.setSexo('M');
        p2.setSexo('F');
        p3.setSexo('M');
        p4.setSexo('M');
        
        p1.setIdade(18);
        p2.setIdade(22);
        p3.setIdade(16);
        p4.setIdade(30);
        
        p2.setSetor('A');
        p2.setTrabalhando(true);
        
        p3.setCurso("Engenharia informática");
        p3.setMat(10);
        
        p4.setEspecialidade("Informática");
        p4.setSalario(2500.5f);
        
        p4.receberAumento(100);
        p2.mudarTrabalho();
        p3.cancelarMat();
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
    }
    
}
