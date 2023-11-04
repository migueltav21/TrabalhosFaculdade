/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generics_aula1_pt2;

import java.util.*;

/**
 *
 * @author Rui Tavares
 */
public class Generics_aula1_pt2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Cao> listaCaes = new ArrayList();
        listaCaes.add(new Cao());
        listaCaes.add(new Cao());

        List<Gato> listaGatos = List.of(new Gato(), new Gato());
        List<Animal> listaAnimais = new ArrayList();
        listaAnimais.add(new Gato());
        listaAnimais.add(new Cao());
        printconsulta(listaAnimais);
        printconsulta(listaGatos); 
        printConsultaAnimal(listaCaes);
         printConsultaAnimal(listaAnimais);
         printconsulta(listaAnimais);

    }

    private static void printconsulta(List<? extends Animal> lista) {
        for (Animal lista1 : lista) {
            lista1.consulta();
        }
        // nao posso adicionar nada visto que a função aceita qualquer tipo de animal
        //  lista.add(new Gato());
    }

    private static void printConsultaAnimal(List<? super Cao> lista) {
        lista.add(new Cao());
    }

}
