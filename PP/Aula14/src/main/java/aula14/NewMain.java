package aula14;

public class NewMain {

    public static void main(String[] args) {
        Video v[] = new Video[3];
        v[0] = new Video("AAA", 7.8, 200, 15);
        v[1] = new Video("BBB", 2.3, 500, 10);
        v[2] = new Video("CCC", 9.8, 1002, 200);

        Gafanhoto g[] = new Gafanhoto[2];
        g[0] = new Gafanhoto("123", 2, "Miguel", 18, "M", 10);
        g[1] = new Gafanhoto("aaa", 1, "Joao", 16, "M", 7);
        
        System.out.println(v[0].toString());
        System.out.println(v[1].toString());
        System.out.println(v[2].toString());
        System.out.println(g[0].toString());
        System.out.println(g[1].toString());
        
        Vizualizacao vis = new Vizualizacao(g[1], v[0]);
        System.out.println(vis.toString());
    }

}
