/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class main {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TV televisao1 = new TV();
        
        System.out.println("A televisão é da marca " + televisao1.fabricante +
        "e tem " + televisao1.polegadas + " polegdas");
        System.out.println("A televisao está " + (televisao1.ligado == true ? "ligada" : "desligada"));
        
        
        televisao1.ligar();
        televisao1.aumentarVolume();
        televisao1.aumentarVolume();
        
        
        System.out.printf("O volume é %d\n", televisao1.volume);
         System.out.println("A televisao está " + (televisao1.ligado == true ? "ligada" : "desligada"));
    }
    
}
