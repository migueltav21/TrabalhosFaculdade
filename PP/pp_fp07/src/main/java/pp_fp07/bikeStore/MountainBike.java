package pp_fp07.bikeStore;

import pp_fp07.bikeStore.Enums.*;
import java.util.*;

public class MountainBike extends Bike {

    private int numberOfLigths;
    private Suspension suspension;
    private ArrayList<BikeTools> bikeTools = new ArrayList<>();

    public MountainBike(int numberOfLigths, Suspension suspension, ArrayList<BikeTools> bikeTools, int id, int numberOfGears, String mainColor, float wheelSize, Brakes brakes, Material material, float price, int guarantee) {
        super(id, numberOfGears, mainColor, wheelSize, brakes, material, price, guarantee);
        this.numberOfLigths = numberOfLigths;
        this.suspension = suspension;
        this.bikeTools = bikeTools;
    }

    public int getNumberOfLigths() {
        return numberOfLigths;
    }

    public void setNumberOfLigths(int numberOfLigths) {
        this.numberOfLigths = numberOfLigths;
    }

    public Suspension getSuspension() {
        return suspension;
    }

    public void setSuspension(Suspension suspension) {
        this.suspension = suspension;
    }

    public ArrayList<BikeTools> getBikeTools() {
        return bikeTools;
    }

    public void setBikeTools(ArrayList<BikeTools> bikeTools) {
        this.bikeTools = bikeTools;
    }

    public void addBikeTools(BikeTools tool) {
        if (this.bikeTools.size() == 5) {
            System.out.println("A bicicleta não pode ter mais acessórios");
        }
        boolean auxiliar = true;

        for (int i = 0; i < this.getBikeTools().size(); i++) {
            if (this.bikeTools.get(i) == tool) {
                System.out.println("Esse acessório já está presente na bicicleta");
                auxiliar = false;
            }
        }

        if (auxiliar == true) {
            this.bikeTools.add(tool);
        }

    }

    public void removeBikeTools(BikeTools tool) {
        this.bikeTools.remove(tool);
    }

    public void editeBikeTools(BikeTools NewTool, BikeTools OldTool) {
        removeBikeTools(OldTool);
        addBikeTools(NewTool);
    }

    @Override
    public String toString() {
        return "MountainBike{" + "numberOfLigths=" + numberOfLigths + ", suspension=" + suspension + ", bikeTools=" + bikeTools + ", id=" + this.getId() + ", numberOfGears=" + this.getNumberOfGears() + ", mainColor=" + this.getMainColor() + ", wheelSize=" + this.getWheelSize() + ", brakes=" + this.getBrakes() + ", material=" + this.getMaterial() + ", price=" + this.getPrice() + ", guarantee=" + this.getGuarantee() + '}';
    }

}
