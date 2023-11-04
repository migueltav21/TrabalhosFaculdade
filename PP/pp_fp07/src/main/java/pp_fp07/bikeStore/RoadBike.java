package pp_fp07.bikeStore;

import pp_fp07.bikeStore.Enums.*;
public class RoadBike extends Bike{
    
    private float framesize;
    private String observations;

    public RoadBike(float framesize, String observations, int id, int numberOfGears, String mainColor, float wheelSize, float price, int guarantee) {
        super(id, numberOfGears, mainColor, wheelSize, Brakes.HIDRÁULICOS , Material.CARBONO , price, guarantee);
        this.framesize = framesize;
        setObservations(observations);
    }

    public float getFramesize() {
        return framesize;
    }

    public void setFramesize(float framesize) {
        this.framesize = framesize;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        if(observations.length() <= 50){
        this.observations = observations;
        }else{
           this.observations = observations.substring(0, 50);
            }
        }

    @Override
    public String toString() {
        return "RoadBike{" + "framesize=" + framesize + ", observations=" + observations + ", id=" + this.getId() + ", numberOfGears=" + this.getNumberOfGears() + ", mainColor=" + this.getMainColor() + ", wheelSize=" + this.getWheelSize() + ", brakes=" + this.getBrakes() + ", material=" + this.getMaterial() + ", price=" + this.getPrice() + ", guarantee=" + this.getGuarantee() + '}';
    }
    
    
    
    
    
    }
    
    
   
