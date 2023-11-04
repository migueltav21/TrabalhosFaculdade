/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha1_ex2_;

/**
 *
 * @author Rui Tavares
 * @param <T>
 */
public class Pair<T extends Comparable> {

    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    

    public T max() {
        if (first.compareTo(second) >= 0) {
            return first;
        } else {
            return second;
        }
    }
}
