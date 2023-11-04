/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generics_aula2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rui Tavares
 */
public class Generics_aula2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarroRentavel carros = new CarroRentavel();
        Carro carro1 = carros.levantarCarroDisponivel();
        carros.retomarCarroAlugado(carro1);

        BarcoRentalService barcos = new BarcoRentalService();
        Barco barco1 = barcos.levantarBarcoDisponivel();
        barcos.retomarBarcoAlugado(barco1);

        List<Carro> carros1 = new ArrayList<>(List.of(new Carro("Fiat punto"), new Carro("BMW")));
        List<Barco> barcos1 = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Iate")));
        
        RentalService<Carro> rentalService = new RentalService<>(carros1);
        rentalService.levantarObjetoDisponivel();
        
        RentalService<Barco> rentalServiceBarco = new RentalService<>(barcos1);
        rentalServiceBarco.levantarObjetoDisponivel();

    }

}
