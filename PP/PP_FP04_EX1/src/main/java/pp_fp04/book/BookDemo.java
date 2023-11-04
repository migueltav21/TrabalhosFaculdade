/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp_fp04.book;

/**
 *
 * @author joao
 */
public class BookDemo {

    public static void main(String[] args) {
        Book book = new Book();
        book.ano = 2000;
        book.editor = "Porto editora";
        book.paginas = 423;
        book.titulo = "Vale tudo!";
        System.out.println("Avaliação nº1:");
        book.avalicao[0] = book.avaliacao();
        System.out.println("Avaliação nº2:");
        book.avalicao[1] = book.avaliacao();
        System.out.println("Avaliação nº3:");
        book.avalicao[2] = book.avaliacao();
        book.autores[0] = new Authors();
        book.autores[1] = new Authors();
        book.autores[0].nomeAutor = "José Saramago";
        book.autores[1].nomeAutor = "Pedro Zezocs";
        book.autores[0].nacionalidade = "Portuguesa";
        book.autores[1].nacionalidade = "Espanhola";
        book.autores[0].acronimo[0] = 'J';
        book.autores[0].acronimo[1] = 'S';
        book.autores[0].acronimo[2] = 'M';
        book.autores[1].acronimo[0] = 'P';
        book.autores[1].acronimo[1] = 'T';
        book.autores[1].acronimo[2] = 'S';
        
        System.out.println("-----------Informação do livro-----------");
        System.out.printf("Nome: %s\n", book.titulo);
        System.out.printf("Ano de lançamento: %d\n", book.ano);
        System.out.printf("Editora: %s\n", book.editor);
        System.out.printf("Numero de paginas: %d\n", book.paginas);
        for(int i = 0; i<3; i++){
        System.out.printf("Avaliação %d: %d\n",i+1, book.avalicao[i]);
        }
        System.out.println("------------------------------------------");
         System.out.println("-----------Informação dos autores-----------");
        for(int i = 0; i<2; i++){
            System.out.printf("Autor nº%d\n", i+1);
            System.out.printf("Nome: %s\n", book.autores[i].nomeAutor);
            System.out.printf("Nacionalidade: %s\n", book.autores[i].nacionalidade);
            System.out.print("Acronimo:");
            for( int j =0; j<3; j++){
                System.out.printf("%s", book.autores[i].acronimo[j]);
            }
            System.out.print("\n");
        }
        
        
        
    }

}
