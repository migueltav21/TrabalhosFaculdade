/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Canteta caneta = new Canteta();
        
        caneta.modelo = "BIC";
        caneta.cor = "Azul";
       // caneta.ponta = 0.5f;
        caneta.carga = 80;
        
        caneta.status();
        
        caneta.tapar();
        caneta.cor = "Vermelho";
        
        caneta.status();
        
    }
    
}
