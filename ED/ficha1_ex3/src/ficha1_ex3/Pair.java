/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha1_ex3;

/**
 *
 * @author Rui Tavares
 */
public class Pair<T> {

    private T first;
    private T second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public boolean VerificarIgualdade() {
        if (first.equals(second)) {
            return true;
        }else
        {
            return false;
        }
    }

}
