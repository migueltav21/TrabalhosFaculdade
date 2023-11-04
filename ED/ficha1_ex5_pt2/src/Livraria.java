
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Rui Tavares
 */
public class Livraria<T> {

    List<T> livraria;

    public Livraria(List<T> livraria) {
        this.livraria = livraria;
    }

    public void verMediaDisponivel() {
        System.out.println("Disponivel para alugar:");
        for (T livraria1 : livraria) {
            System.out.println(livraria1.toString());
        }
        System.out.println("-----------------------------");
    }

    public T alugar(int num) {
        try{
        return livraria.remove(num);
        }catch(Exception e){
            System.out.println("Impossivel requisitar.");
            return null;
        }
    }
    
    public void devolver(T objeto){
        livraria.add(objeto);
    }
}
