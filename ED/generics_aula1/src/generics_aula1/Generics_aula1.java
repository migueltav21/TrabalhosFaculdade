/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generics_aula1;

/**
 *
 * @author Rui Tavares
 */
public class Generics_aula1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cao[] cachorros = {new Cao(), new Cao()};
        Gato[] gatos = new Gato[2];
        gatos[0] = new Gato();
        gatos[1] = new Gato();
       Animal[] animais = {new Gato(), new Cao()};
        
        printConsulta(cachorros);
        printConsulta(gatos);
         printConsulta(animais);
    }

    private static void printConsulta(Animal[] animal) {
        for (Animal animall : animal) {
            animall.consulta();
        }
        for(int i = 0; i < animal.length; i++){
            animal[i].consulta();
        }
        //animal[1] = new Cao(); Só se adiciona caso estejamos a passar arrays do tipo mais genérico
        //Não é a melhor opção
        System.out.println("-----------------------");
    }

}
