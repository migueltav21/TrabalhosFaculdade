/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class Canteta {
    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    private boolean tapada;
    
    public void status(){
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Cor: " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga);
        System.out.println("Esta tapada? " + this.tapada); 
    }
    
    public void rabiscar(){
        if(this.tapada == true){
            System.out.println("Não dá para escrever pq a caneta está fechada");
        }else{
            System.out.println("A caneta está a escrever");
        } 
    }
    
    public void tapar(){
        this.tapada = true;
    }
    
    public void destapar(){
        this.tapada = false;
    }
    
}
