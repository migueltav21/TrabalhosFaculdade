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
        mamifero x = new mamifero();
        x.emitirsom();
        Cachorro c = new Cachorro();
        c.reagir("Ola");
        c.reagir(11, 45);
        c.reagir(19, 0);
    }
    
}
