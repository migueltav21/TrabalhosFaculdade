package pp_fp07.bikeStore;

import pp_fp07.bikeStore.Enums.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Bike bike1 = new Bike(111, 100, "black", 20, Brakes.PINÇAS, Material.CARBONO, 200.4f, 20);
        System.out.println(bike1.toString());
        
        ArrayList<BikeTools> biketoolsDefault = new ArrayList<>();
        biketoolsDefault.add(BikeTools.ALFORJE);
        biketoolsDefault.add(BikeTools.CONTA_KM);
        
        MountainBike bike2 = new MountainBike(2, Suspension.DUPLA, biketoolsDefault , 222, 200, "white", 30, Brakes.HIDRÁULICOS, Material.ALUMINIO, 550.8f, 3);
        System.out.println(bike2.toString());
        
        RoadBike bike3 = new RoadBike(10, "asasasasasasakjgffghjiuyfdrxfgvhbhçidtrxfghbjhiotudtxfcgvhuiutaaaq", 333, 80, "gray", 22, 100.2f, 5);
        bike3.setBrakes(Brakes.HIDRÁULICOS);
        System.out.println(bike3.toString());
        
        Bike bike4 = new RoadBike(999, "Biciclta para andar na rua", 100, 100, "amarela", 30, 70.2f, 2);
        bike2.removeBikeTools(BikeTools.ALFORJE);
        bike2.addBikeTools(BikeTools.KIT_REPARAÇAO_PNEU);
        bike2.addBikeTools(BikeTools.SUPORTE_TELEMOVEL);
        bike2.addBikeTools(BikeTools.SUPORTE_TELEMOVEL);
        bike2.addBikeTools(BikeTools.ALFORJE);
        
        
        System.out.println("--------------------------------------------------");
        ArrayList<Bike> bikesDefault= new ArrayList<>();
        bikesDefault.add(bike1);
        bikesDefault.add(bike2);
        bikesDefault.add(bike3);
        
        BicycleManagement loja = new BicycleManagement(bikesDefault);
        loja.listarBikes();
        loja.adicionarBike(bike4);
        loja.removerBike(bike1);
        loja.listarBikes();
        loja.listarMounatinBike();
    }

}
