/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha2_ex1_;

/**
 *
 * @author Rui Tavares
 */
public class No <T>{

    private T elemento;
    private No proximo;

        public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public No(T elemento, No proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    } 
    
    
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No{" + "elemento=" + elemento + ", proximo=" + proximo + '}';
    }
    
    
}
