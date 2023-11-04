
package aula12;

public class Mamifero extends Animal{
private String corPelo;

    public Mamifero(String corPelo, float peso, int idade, int membros) {
        super(peso, idade, membros);
        this.corPelo = corPelo;
    }

    public String getCorPelo() {
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }
    
    
    @Override
    public void locomover() {
        System.out.println("A correr...");
    }

    @Override
    public void alimentar() {
        System.out.println("A mamar...");
    }

    @Override
    public void emitirSom() {
         System.out.println("Som de mamifero");
    }
    
}
