package Aula05;

public class NewMain {

    public static void main(String[] args) {
        ContaBanco p1 = new ContaBanco();
        ContaBanco p2 = new ContaBanco();
        p1.setDono("Miguel");
        p1.setNumConta(100);
        p1.abrirConta("CC");

        p2.setDono("Joana");
        p2.setNumConta(200);
        p2.abrirConta("CP");

        p1.depositar(100);
        p2.depositar(500);

        p1.estaduAtual();
        p2.estaduAtual();

        p2.tirar(100);
        p2.estaduAtual();
        
        p1.tirar(150);
        p1.fecharConta();
        p1.estaduAtual();
    }

}
