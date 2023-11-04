/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha4;
import pp_fp04.exchange.CurrenyRates;

public class Main {
static CurrenyRates rates;
static User user1 = null, user2 = null;
    public static void main(String[] args) {
        
        int a = 100;
        int b = 310;
        double totalDespesa = 0, totalCarro = 0, totalComida = 0, mediaCarro = 0, mediaComida = 0;
        user1.email = "migueltav5@gmail.com";
        user1.id[0] = 'A';
        user1.id[1] = 'B';
        user1.id[2] = 'C';
        user1.nome = "Miguel Tavares";
        //Despesas associdas ao user1
        user1.expenses.number1 = 10;
        user1.expenses.number2 = 20;
        user1.expenses.descricaoCar = "Carro macaco\n";
        user1.expenses.descricaoFood = "Comida olga\n";
        for (int i = 0; i < user1.expenses.carValeus.length; i++) {
            user1.expenses.carValeus[i] = a++;
            b -= 10;
            user1.expenses.foodValeus[i] = b;
        }

        System.out.println("--------User1--------");
        System.out.print("ID:");
        System.out.println(user1.id);
        System.out.print("Nome:");
        System.out.print(user1.nome + "\n");
        System.out.print("Email:");
        System.out.print(user1.email + "\n");
        System.out.printf("Despesa nº %d\n", user1.expenses.number1);
        System.out.printf("Descrição da despesa: %s\n", user1.expenses.descricaoCar);
        for (int i = 0; i < user1.expenses.carValeus.length; i++) {
            System.out.printf("Valor da despesa do carro:\n Dia %d: %.2f\n", i + 1, user1.expenses.carValeus[i]);
        }

        System.out.printf("Despesa nº %d\n", user1.expenses.number2);
        System.out.printf("Descrição da despesa: %s\n", user1.expenses.descricaoFood);
        for (int i = 0; i < user1.expenses.foodValeus.length; i++) {
            System.out.printf("Valor da despesa da comida:\n Dia %d: %.2f\n", i + 1, user1.expenses.foodValeus[i]);
        }

        user2.email = "joaozzeze@gmail.com";
        user2.id[0] = 'Z';
        user2.id[1] = 'Z';
        user2.id[2] = 'Z';
        user2.nome = "Ze jooanete";

        System.out.println("--------User2--------");
        System.out.print("ID:");
        System.out.println(user2.id);
        System.out.print("Nome:");
        System.out.print(user2.nome + "\n");
        System.out.print("Email:");
        System.out.print(user2.email + "\n");

        System.out.println("--------User1--------");
        System.out.print("ID:");
        System.out.println(user1.id);
        System.out.print("Nome:");
        System.out.print(user1.nome + "\n");
        System.out.print("Email:");
        System.out.print(user1.email + "\n");

        for (int i = 0; i < user1.expenses.carValeus.length; i++) {
            totalComida += user1.expenses.foodValeus[i];
            totalCarro += user1.expenses.carValeus[i];
        }
        totalDespesa = totalComida + totalCarro;
        mediaCarro = totalCarro / 31;
        mediaComida = totalComida / 31;

        System.out.printf("total da despesa do carro: %.2f\n", totalCarro);
        System.out.printf("total da despesa da comida: %.2f\n", totalComida);
        System.out.printf("total das despesas: %.2f\n", totalDespesa);
        System.out.printf("media da despesa do carro: %.2f\n", mediaCarro);
        System.out.printf("media da despesa da comida: %.2f\n", mediaComida);
        
       System.out.printf("Total amount spent on expenses this month in euros: %.2f\n", totalDespesa);
        System.out.printf("Dolar: %.2f\n", totalDespesa * rates.taxDolar);
        System.out.printf("Iene: %.2f\n", totalDespesa * rates.taxIene);
        System.out.printf("GBP: %.2f\n", totalDespesa * rates.taxGBP);

        
        
    }

}
