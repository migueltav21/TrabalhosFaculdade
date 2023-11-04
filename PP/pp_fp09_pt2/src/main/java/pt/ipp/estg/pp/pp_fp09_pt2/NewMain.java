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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle c1 = new Circle(true);
        Circle c2 = new Circle(false, 2);
        Circle c3 = new Circle(true, 2.5, "Blue");
        Circle c4 = new Circle(true, "Black");
        double area, perimetro;

        area = c1.getArea();
        perimetro = c1.getPerimeter();
        System.out.println(area);
        System.out.println(perimetro);
   System.out.println(c1.toString());
        System.out.println("----------");

         area = c2.getArea();
        perimetro = c2.getPerimeter();
        System.out.println(area);
        System.out.println(perimetro);
        System.out.println(c2.toString());
        System.out.println("----------");
        
         area = c3.getArea();
        perimetro = c3.getPerimeter();
        System.out.println(area);
        System.out.println(perimetro);
        System.out.println(c3.toString());
        System.out.println("----------");
    }

}
