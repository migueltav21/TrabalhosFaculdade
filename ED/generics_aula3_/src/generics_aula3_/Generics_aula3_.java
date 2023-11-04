/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generics_aula3_;

import java.util.*;

/**
 *
 * @author Rui Tavares
 */
public class Generics_aula3_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Barco> lista = criarArrayComObjeto(new Barco("Iate"));
    }
    
    private static <T> List<T> criarArrayComObjeto(T t){
        
        List<T> list = new ArrayList<>();
        list.add(t);
        return list;
        
    }
    
}
