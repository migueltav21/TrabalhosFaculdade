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
public class ExpensesDemo {

    public static void main(String[] args) {
        User user1 = new User("Miguel", "gfdfydt@gmail.com", "2004-12-2");
        User user2 = new User("Gabi Gordo", "aaa@gmail.dom", "2001-1-2");
        user1.expenses[0] = new Expenses(1, 200.4f, "automovel", "2020-2-2");
         user1.expenses[1] = new Expenses(200, 100.5f, "alimentar", "2024-5-1");
         user2.expenses[0] = new Expenses(3, 20.5f, "outras", "2019-9-2");
         user2.expenses[1] = new Expenses(6, 89.22f, "automoveis", "2024-5-1");
         
         System.out.println("User1:");
         System.out.println("Nome:" + user1.nome);
         System.out.println("Email: " + user1.email);
         System.out.println("Data de nascimeto:" + user1.dataNascimento);
         System.out.println("Codigo: " + user1.codigo);
         for(int i =0; i<2; i++){
             System.out.println("Despesa " + (i+1));
             System.out.println("Numero de identificação: " + user1.expenses[i].numIdentificacao);
             System.out.println("Valor da despesa: " + user1.expenses[i].valorGasto);
             System.out.println("Tipo da despesa: " + user1.expenses[i].tipo);
             System.out.println("Data da despesa: " + user1.expenses[i].dataDespesa);
         }
         
                System.out.println("\n\n\nUser2:");
         System.out.println("Nome:" + user2.nome);
         System.out.println("Email: " + user2.email);
         System.out.println("Data de nascimeto:" + user2.dataNascimento);
         user2.codigo += user1.codigo;
         System.out.println("Codigo: " + user2.codigo);
         for(int i =0; i<2; i++){
             System.out.println("Despesa " + (i+1));
             System.out.println("Numero de identificação: " + user2.expenses[i].numIdentificacao);
             System.out.println("Valor da despesa: " + user2.expenses[i].valorGasto);
             System.out.println("Tipo da despesa: " + user2.expenses[i].tipo);
             System.out.println("Data da despesa: " + user2.expenses[i].dataDespesa);
         }
         
         
         
    }
}
