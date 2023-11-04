/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication6;

import java.util.*;

/**
 *
 * @author Rui Tavares
 */
public class JavaApplication6 {

    public static void ordenarTamanho(List<String> lista) {
        Collections.sort(lista, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return Integer.compare(str1.length(), str2.length());
            }
        });

        System.out.println(lista);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> lista = new ArrayList();
        lista.add("Miguel");
        lista.add("Joao");
        lista.add("Pedro");
        lista.add("Francisco");
        lista.add("Rui");
        lista.add("Sandra");
        ordenarTamanho(lista);

        List<Integer> lista2 = new ArrayList();
        lista2.add(10);
        lista2.add(222);
        lista2.add(1);
        lista2.add(55);
        lista2.add(3);
        lista2.add(88);

    }

}
