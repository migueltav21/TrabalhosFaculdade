/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha2_ex1;

/**
 *
 * @author Rui Tavares
 */
public class LinkedList {

    public Pessoa head;

    public LinkedList() {
        this.head = null;
    }

  public void add(Pessoa pessoa) {
        if (head == null) {
            head = pessoa;
        } else {
            Pessoa current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(pessoa);
        }
    }
  
   public void remove(String nome) {
        if (head == null) {
            return;
        }

        if (head.getNome().equals(nome)) {
            head = head.getNext();
            return;
        }

        Pessoa current = head;
        while (current.getNext() != null && !current.getNext().getNome().equals(nome)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }

    public void printList() {
        Pessoa current = head;
        while (current != null) {
            System.out.print(current.getNome() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
