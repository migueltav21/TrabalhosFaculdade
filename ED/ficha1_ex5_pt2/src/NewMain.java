
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Rui Tavares
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Video> videos = new ArrayList<>();
        videos.add(new Video("Mr.Beast video"));
        videos.add(new Video("Wuant video"));
        videos.add(new Video("Sr.Kazzio video"));

        List<Livro> livros = new ArrayList<>(List.of(new Livro("O pequeno principe"),
                new Livro("Harry Potter"),
                new Livro("Os cinco")));

        List<Media> media = new ArrayList<>();
        media.add(new Video("Mr Beast"));
        media.add(new Livro("Os cinco"));
        media.add(new CD("Eminem"));

        Livraria<Media> livraria3 = new Livraria(media);
        livraria3.verMediaDisponivel();
        livraria3.verMediaDisponivel();
        

        Livraria<Livro> livraria = new Livraria(livros);
        livraria.verMediaDisponivel();
        Livro livro = livraria.alugar(1);
        System.out.println("Requisitado: " + livro);
        livraria.verMediaDisponivel();
        livraria.devolver(livro);
        livraria.verMediaDisponivel();

        Livraria<Video> livraria2 = new Livraria(videos);
        livraria2.verMediaDisponivel();
        Video video = livraria2.alugar(1);
        System.out.println("Requisitado: " + video);
        livraria2.verMediaDisponivel();
        livraria2.devolver(video);
        livraria2.verMediaDisponivel();

    }

}
