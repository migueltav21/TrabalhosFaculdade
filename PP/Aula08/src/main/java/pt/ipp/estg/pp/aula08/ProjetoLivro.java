package pt.ipp.estg.pp.aula08;

public class ProjetoLivro {

    public static void main(String[] args) {
        Pessoa[] p  = new Pessoa[2];
        Livro[] l = new Livro[3];
        
        p[0] = new Pessoa("Miguel", 18, "M");
        p[1] = new Pessoa("Maria", 22, "F");
        
        l[0] = new Livro("Os maias", "José Saramago", 559, p[0]);
        l[1] = new Livro("Lalaland", "Rate", 200, p[1]);
        l[2] = new Livro("Ancião", "Zeus", 909, p[0]);
        
        l[0].abrir();
        l[0].folhear(200);
        System.out.println(l[0].detalhes());
    }
    
}
