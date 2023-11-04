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
public class BarcoRentalService {
        private List<Barco> barcos = new ArrayList<>(
            List.of(new Barco("Lancha"), new Barco("Iate")));

    public Barco levantarBarcoDisponivel(){
        System.out.println("A procurar barco disponivel...");
        Barco barco = barcos.remove(0);
        System.out.println("Barco alugado: " + barco.toString());
        System.out.println("Carros disponiveis: " + barcos);
        return barco;
    }
    
    public void retomarBarcoAlugado(Barco barco){
        System.out.println("A devolver barco");
        barcos.add(barco);
        System.out.println("Carros disponiveis: " + barcos);
    }

}
