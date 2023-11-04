package pp_fp07.bikeStore;

import pp_fp07.bikeStore.*;

import java.util.*;

public class BicycleManagement {

    private ArrayList<Bike> bicicletasDisponiveis = new ArrayList<>();

    public BicycleManagement(ArrayList array) {
        this.bicicletasDisponiveis = array;
    }

    public ArrayList<Bike> getBicicletasDisponiveis() {
        return bicicletasDisponiveis;
    }

    public void setBicicletasDisponiveis(ArrayList<Bike> bicicletasDisponiveis) {
        this.bicicletasDisponiveis = bicicletasDisponiveis;
    }

    public void adicionarBike(Bike bike) {
        this.bicicletasDisponiveis.add(bike);
    }

    public void removerBike(Bike bike) {
        this.bicicletasDisponiveis.remove(bike);
    }

    public void listarBikes() {
         System.out.println("bikes disponíveis:");
        System.out.println(this.bicicletasDisponiveis.toString());
    }

    public void listarMounatinBike() {
        System.out.println("Mountain bikes:");
        for (Bike bike : this.bicicletasDisponiveis) {
            if (bike instanceof MountainBike) {
                System.out.println(((MountainBike) bike).toString());
            }
        }
    }

}
