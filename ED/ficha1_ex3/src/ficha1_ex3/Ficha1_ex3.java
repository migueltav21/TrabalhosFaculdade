/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficha1_ex3;

/**
 *
 * @author Rui Tavares
 */
public class Ficha1_ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UnorderedPair<Integer> par = new UnorderedPair<>(10, 30);
        UnorderedPair<Integer> par2 = new UnorderedPair<>(10, 90);
        UnorderedPair<String> par3 = new UnorderedPair<>("aa", "bb");
        UnorderedPair<String> par4 = new UnorderedPair<>("aa", "aa");
        UnorderedPair<Integer> par5 = new UnorderedPair<>(1, 15);
        System.out.println(par3.getSecond());
        System.out.println(par.equals(par));
        System.out.println(par.getFirst());
        System.out.println(par2.getSecond());
        System.out.println(par4.VerificarIgualdade());
        System.out.println(par5.VerificarIgualdade());
    }
    
}
