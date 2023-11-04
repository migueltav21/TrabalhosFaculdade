/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha1_ex3;

/**
 *
 * @author Rui Tavares
 */
public class UnorderedPair<T> extends Pair<T>{

    public UnorderedPair() {
        setFirst(null);
        setSecond(null);
    }

    public UnorderedPair(T firstItem, T secondItem) {
        setFirst(firstItem);
        setSecond(secondItem);
    }
   
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            UnorderedPair<T> otherPair
                    = (UnorderedPair<T>) otherObject;
            return (getFirst().equals(otherPair.getFirst())
                    && getSecond().equals(otherPair.getSecond()))
                    || (getFirst().equals(otherPair.getSecond())
                    && getSecond().equals(otherPair.getFirst()));
        }
    }
    
}
