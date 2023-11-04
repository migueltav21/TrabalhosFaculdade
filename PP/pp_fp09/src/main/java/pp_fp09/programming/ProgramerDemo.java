package pp_fp09.programming;

import pp_fp09.programming.Enums.*;

public class ProgramerDemo {

    public static void main(String[] args) {
        Administrativo a1 = new Administrativo("RSJ", TipoContrato.PARCIAL, Habilitacoes.LICENCIATURA, "1-1-2003", "2-2-2007", "Ricardo, Jorge Silva", "21-4-1970", "Rua", 111111, 222222, 1000);
        Administrativo a2 = new Administrativo("RSJ", TipoContrato.INTEGRAL, Habilitacoes.MESTRADO, "1-1-2003", "2-2-2007", "Ricardo, Jorge Silva", "21-4-1970", "Rua", 111111, 222222, 1000);
        Administrativo a3 = new Administrativo("RSJ", TipoContrato.INTEGRAL, Habilitacoes.DOUTURAMENTO, "1-1-2003", "Ricardo, Jorge Silva", "21-4-1970", "Rua", 111111, 222222, 1000);

        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());

        GestorProjeto g1 = new GestorProjeto(1791, 5, "Daniel", "1 de abril de 2000", "aaa", 121212, 22222, 1000);
        GestorProjeto g2 = new GestorProjeto(1791, 10, "Daniel", "1 de abril de 2000", "aaa", 121212, 22222, 1000);
        System.out.println(g1.toString());
        System.out.println(g2.toString());
        g1.adicionarProjeto("projeto1");
        g1.adicionarProjeto("projeto2");
        g2.adicionarProjeto("projeto3");
        System.out.println(g1.toString());
        System.out.println(g2.toString());
        
        Programador p1 = new Programador(0001, 8, "sas", TipoProg.SENIOR, "Miguel", "29 outubro 2004", "qqq", 90909,3333, 1000);
         System.out.println(p1.toString());
         
         Pessoa pessoas[] = {a2, g1, p1};
         ProgrammingManagement empresa = new ProgrammingManagement(pessoas);
         empresa.listarFuncionarios();
         empresa.adicionarFuncionario(a3);
         empresa.adicionarFuncionario(g2);
         empresa.listarFuncionarios();
         empresa.removerFuncionario(a1);
         empresa.removerFuncionario(g1);
         empresa.listarFuncionarios();
    }

}
