/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package so_ficha1_ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Rui Tavares
 */
public class So_ficha1_ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Por favor, forneça o nome do arquivo de entrada.");
            return;
        }

        String arquivoNome = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoNome))) {
            String linha;
            double valor1 = 0;
            double valor2 = 0;

            // Lê as duas primeiras linhas do arquivo como valores double
            if ((linha = br.readLine()) != null) {
                valor1 = Double.parseDouble(linha);
            } else {
                System.out.println("O arquivo está vazio ou não contém valores suficientes.");
                return;
            }

            if ((linha = br.readLine()) != null) {
                valor2 = Double.parseDouble(linha);
            } else {
                System.out.println("O arquivo não contém dois valores.");
                return;
            }

            // Realiza os cálculos
            double soma = valor1 + valor2;
            double subtracao = valor1 - valor2;
            double multiplicacao = valor1 * valor2;

            // Verifica se o segundo valor é diferente de zero antes de calcular a divisão
            double divisao;
            if (valor2 != 0) {
                divisao = valor1 / valor2;
            } else {
                System.out.println("Divisão por zero não é permitida.");
                return;
            }

            // Imprime os resultados
            System.out.println("Soma: " + soma);
            System.out.println("Subtração: " + subtracao);
            System.out.println("Multiplicação: " + multiplicacao);
            System.out.println("Divisão: " + divisao);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("O arquivo contém valores inválidos: " + e.getMessage());
        }
    }

}
