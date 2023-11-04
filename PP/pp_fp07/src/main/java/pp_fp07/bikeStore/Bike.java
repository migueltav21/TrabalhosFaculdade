package pp_fp07.bikeStore;

import pp_fp07.bikeStore.Enums.*;

public class Bike {
    private int id;
    private int numberOfGears;
    private String mainColor;
    private float wheelSize;
    private Brakes brakes;
    private Material material;
    private float price;
    private int guarantee;

    public Bike(int id, int numberOfGears, String mainColor, float wheelSize, Brakes brakes, Material material, float price, int guarantee) {
        this.id = id;
        this.numberOfGears = numberOfGears;
        this.mainColor = mainColor;
        this.wheelSize = wheelSize;
        this.brakes = brakes;
        this.material = material;
        this.price = price;
        this.guarantee = guarantee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public float getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(float wheelSize) {
        this.wheelSize = wheelSize;
    }

    public Brakes getBrakes() {
        return brakes;
    }

    public void setBrakes(Brakes brakes) {
        this.brakes = brakes;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    @Override
    public String toString() {
        return "Bike{" + "id=" + id + ", numberOfGears=" + numberOfGears + ", mainColor=" + mainColor + ", wheelSize=" + wheelSize + ", brakes=" + brakes + ", material=" + material + ", price=" + price + ", guarantee=" + guarantee + '}';
    }
    
    
    
}
