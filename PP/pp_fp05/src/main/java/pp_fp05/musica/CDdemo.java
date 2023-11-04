/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp_fp05.musica;

import fp_fp05.store.Sale;
import fp_fp05.store.User;

/**
 *
 * @author joao
 */
public class CDdemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaração de uma música usado apenas a classe música
        Musica musica = new Musica(1, "mockinbird", 300);
        System.out.println("Numero da faixa: " + musica.numeroFaixa + "\nNome:" + musica.nomeFaixa + "\nTempo em segundos:" + musica.duracao);

        //Criação(instanciar) de um CD com informação
        CD cd = new CD("Nirvana", "zazazaz", "1985-3-8", "Gorilla");
   
        //Atribuição dos cantores ao Cd uma vez que a classe banda(cantores) está
        //associada à classe Cd
        cd.banda[0] = new Banda("Drake", "Canada", "1978-1-3");
        cd.banda[1] = new Banda("The Weekend", "Estados Unidos", "1995-3-5");
        cd.banda[2] = new Banda("Eminem", "Portugal", "2000-1-1");

        //Criação de uma música
        int n = cd.musica.length;
        System.out.println(n);
        cd.musica[0] = new Musica(1, "Lalala", 120);
        cd.musica[n - 1] = new Musica(15, "Evoque prata", 207);

        //Criação dos autores das músicas
        cd.musica[0].autor[0] = new Autor("Vendedor", "Dr.Dre", 50, "Rua manuel jose", 123456789, 5000);
        cd.musica[0].autor[1] = new Autor("Publico", "Sandra", 52, "Rua do cao", 111111111, 0);

        cd.musica[n - 1].autor[0] = new Autor("Vendedor", "50 cent", 56, "Wall Streat", 2121, 10000);
        cd.musica[n - 1].autor[1] = new Autor("Vendedor", "SnoopDogg", 80, "Havai", 000, 5656565);
        cd.musica[n - 1].autor[2] = new Autor("Publico", "Mc paiva", 21, "Favela", 1, 0);
        //Contagem dos segundos do album
        for (int i = 0; i < cd.musica.length; i++) {
            if (cd.musica[i] != null) {
                cd.tempoSegundos += cd.musica[i].duracao;
            }
        }

        //Print da informação do CD
        System.out.println("------" + cd.nomeCD + "------");
        System.out.println("Ano de lançamento: " + cd.dataLancamento);
        System.out.println("Editora: " + cd.editora);
        System.out.println("Tempo em segundos: " + cd.tempoSegundos);
        System.out.println("Preço: " + cd.price);
        cd.price = cd.cdPrice(10.55);
          System.out.println("Preço: " + cd.price);
        System.out.println("<<Cantores>>");
        //Print da informação dos cantores
        for (int i = 0; i < cd.banda.length; i++) {
            if (cd.banda[i] != null) {
                System.out.println("Nome: " + cd.banda[i].nomeArtista);
                System.out.println("Pais: " + cd.banda[i].nacionalidade);
                System.out.println("Data de nascimento: " + cd.banda[i].dataNascimento);
            }
        }

        //Print da informação sobre a música
        for (int i = 0; i < cd.musica.length; i++) {
            if (cd.musica[i] != null) {
                System.out.println("---");
                System.out.println("Musica " + (i + 1));
                System.out.println("Nome da musica: " + cd.musica[i].nomeFaixa);
                System.out.println("Numero faixa: " + cd.musica[i].numeroFaixa);
                System.out.println("tempo (em segundos): " + cd.musica[i].duracao);
                //Print da informação dos autores
                for (int j = 0; j < cd.musica[i].autor.length; j++) {
                    if (cd.musica[i].autor[j] != null) {
                        System.out.println("Autor " + (j + 1));
                        if ("Vendedor".equals(cd.musica[i].autor[j].tipo)) {
                            System.out.println("Nome: " + cd.musica[i].autor[j].nome);
                            System.out.println("Morada: " + cd.musica[i].autor[j].morada);
                            System.out.println("Idade: " + cd.musica[i].autor[j].idade);
                            System.out.println("NIF: " + cd.musica[i].autor[j].nif);
                            System.out.println("NIB: " + cd.musica[i].autor[j].NIB);
                        } else {
                            System.out.println("Nome: " + cd.musica[i].autor[j].nome);
                            System.out.println("Idade: " + cd.musica[i].autor[j].idade);
                        }
                    }
                }

            }
        }

        
        User user1 = new User("Miguel Tavares", 18, "migueltav5@gmail.com");
        user1.sale = new Sale();
      user1.sale.data = "2023-2-3";
      user1.sale.cd[0] = cd;
      user1.sale.precoTotal = cd.price;
      
      
      
        
    }

}
