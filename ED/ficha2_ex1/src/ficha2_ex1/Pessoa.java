/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha2_ex1;

/**
 *
 * @author Rui Tavares
 */
public class Pessoa {
    private String nome;
    private Pessoa next;

    public Pessoa(String nome) {
        this.nome = nome;
        this.next = null;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa getNext() {
        return next;
    }
    
        public void setNext(Pessoa next) {
        this.next = next;
    }
    
    
}
