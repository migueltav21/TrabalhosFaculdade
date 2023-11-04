/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generics_aula2;

import java.util.*;

/**
 *
 * @author Rui Tavares
 */
public class RentalService<T> {

    private List<T> ObjetosDisponiveis;

    public RentalService(List<T> ObjetosDisponiveis) {
        this.ObjetosDisponiveis = ObjetosDisponiveis;
    }
    
    

    public T levantarObjetoDisponivel() {
        System.out.println("A procurar objeto disponivel...");
        T t = ObjetosDisponiveis.remove(0);
        System.out.println("Carro alugado: " + t.toString());
        System.out.println("Carros disponiveis: " + ObjetosDisponiveis);
        return t;
    }

    public void retomarObjetoAlugado(T t) {
        System.out.println("A devolver objeto");
        ObjetosDisponiveis.add(t);
        System.out.println("Objetos disponiveis: " + t);
    }
}
