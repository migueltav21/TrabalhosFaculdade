package aula10;

public class Main {

    public static void main(String[] args) {
        Visitante v1 = new Visitante();
        
        v1.setIdade(18);
        v1.setNome("João");
        v1.setSexo("M");
        System.out.println(v1.toString());
        
        Aluno a1 = new Aluno();
        a1.setNome("Roberto");
        a1.setCurso("Solicitadoria");
        a1.setIdade(18);
        a1.setSexo("M");
        a1.setMatricula(101010);
        a1.pagarMensalidade();
        
        Bolsista b1 = new Bolsista();
        b1.setMatricula(999);
        b1.setNome("Rafael");
        b1.setCurso("Informática");
        b1.setBolsa(12.5f);
        b1.setSexo("M");
        b1.setIdade(17);
        b1.pagarMensalidade();
    }
    
}
