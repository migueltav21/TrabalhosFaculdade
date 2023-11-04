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
     Caneta caneta = new Caneta();
     caneta.setModelo("BIC");
     caneta.setPonta(0.5f);
     caneta.status();
     
     System.out.println("A caneta é do modelo " + caneta.getModelo()
     + " e de ponta " + caneta.getPonta());
     
     Caneta caneta2 = new Caneta("Ronaldo", 7.0f, true, "vermelho");
     caneta2.status();
    }
    
}
