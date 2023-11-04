/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class TV {
    String fabricante = "Sony";
    int polegadas = 32;
    int volume = 20;
    int canal = 1;
    boolean ligado = false;
    
    
    public void aumentarVolume(){
        if(volume>= 100){
            return;
        }
        volume++;  
    }
    
    public void diminuirVolume(){
        if(volume <= 0){
            return;
        }
        volume--;
    }
   
    public void ligar(){
        ligado = true;
    }
    
    public void desligar(){
        ligado = false; 
    }
}
