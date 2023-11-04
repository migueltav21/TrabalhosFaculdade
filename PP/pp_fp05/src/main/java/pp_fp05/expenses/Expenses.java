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
public class Expenses {

    public int numIdentificacao;
    public float valorGasto;
    public String tipo;
    public String dataDespesa;
    
    
    public Expenses(int num, float valor, String tipoTemp, String data){
        numIdentificacao = num;
        valorGasto = valor;
        tipo = tipoTemp;
        dataDespesa = data;
    }
}
