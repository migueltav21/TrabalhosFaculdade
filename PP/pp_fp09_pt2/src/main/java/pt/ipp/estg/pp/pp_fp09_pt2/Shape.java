package pt.ipp.estg.pp.pp_fp09_pt2;

public abstract class Shape {
    private String color = "red";
    private boolean filled;

    public Shape(boolean filled, String color) {
        this.filled = filled;
        this.color = color;
    }

    public Shape(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();
}
