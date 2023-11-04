/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp_fp05.expenses;

/**
 *
 * @author joao
 */
public class User {

    Expenses[] expenses;
    int codigo;
    String nome;
    String email;
    String dataNascimento;

    public User(String nomeTemp, String emailTemp, String dataTemp) {
        expenses = new Expenses[31];
        nome = nomeTemp;
        codigo++;
        email = emailTemp;
        dataNascimento = dataTemp;
    }

}
