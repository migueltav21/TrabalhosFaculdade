/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficha1_ex4;

/**
 *
 * @author Rui Tavares
 */
public class Ficha1_ex4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

         /*Neste caso aqui o progama compila caso Point seja constituido por dois numeros
        Visto que point é definido por abcissa e ordenada, o programa era copilado sem erros
        uma vez que criamos um array de pontos com 10 espaços alocados
        de seguida criamos um array de objetos e dizmos que o mesmo é igual ao array de pontos
        na última linha dizemos que a posição 0 do array de objetos recebe um ponto, por isso
        o programa compilaria sem erros
        Point[] a = new Point[10];
        Object[] b;
        b = a;
        b[0] = new Point(10, 20);
         */
        
        /*Neste caso aqui é criado um array em que cabem 10 pontos
        de seguida cria-se um array de objetos e diz se que esse mesmo array é igaul ao array de pontos
        pr último diz-se que a primeria posição do array de objetos recebe uma string,
        visto que uma string é um objeto, o array ficaria com uma string na primeira posição e pontos nas restantes
        por isso, o código compilaria.
        
       Point[] a = new Point[10];
       Object[] b;
       b = a;
       b[0] = "Magical Mystery Tour";
         */
        
        /*Neste exemplo aqui o código não ia compilar visto que tentamos adicionar na posição 0
        uma string num array de pontos, por isso ía dar erro
        Point[] a = new Point[10];
        Object[] b;
        b = a;
        a[0] = "Magical Mystery Tour";
        */
    }

}
