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
public class CarroRentavel {

    private List<Carro> carros = new ArrayList<>(
            List.of(new Carro("Fiat punto"), new Carro("BMW")));

    public Carro levantarCarroDisponivel(){
        System.out.println("A procurar carro disponivel...");
        Carro carro = carros.remove(0);
        System.out.println("Carro alugado: " + carro.toString());
        System.out.println("Carros disponiveis: " + carros);
        return carro;
    }
    
    public void retomarCarroAlugado(Carro carro){
        System.out.println("A devolver carro");
        carros.add(carro);
        System.out.println("Carros disponiveis: " + carros);
    }
    
    
}
