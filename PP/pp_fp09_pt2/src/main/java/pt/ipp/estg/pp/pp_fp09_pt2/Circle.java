/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.estg.pp.pp_fp09_pt2;

/**
 *
 * @author joao
 */
public class Circle extends Shape {

    private double radius = 1.0;

    public Circle(boolean filled) {
        super(filled);
    }

    public Circle(boolean filled, double radius) {
        super(filled);
        this.radius = radius;
    }

    public Circle(boolean filled, double radius, String color) {
        super(filled, color);
        this.radius = radius;
    }

    public Circle(boolean filled, String color) {
        super(filled, color);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        double area = this.radius * 3.1416;
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimetro = 2 * 3.1416 * this.getRadius();
        return perimetro;
    }

    @Override
    public String toString() {
        return "Circle:" + "radius=" + radius + " ,color" + this.getColor() + " ,Filled?" + this.isFilled();
    }

    
}
