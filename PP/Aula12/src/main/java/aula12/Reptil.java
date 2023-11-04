package aula12;

public class Reptil extends Animal{
    private String corEscama;

    public Reptil(String corEscama, float peso, int idade, int membros) {
        super(peso, idade, membros);
        this.corEscama = corEscama;
    }

    public String getCorEscama() {
        return corEscama;
    }

    public void setCorEscama(String corEscama) {
        this.corEscama = corEscama;
    }

    @Override
    public void locomover() {
         System.out.println("A rastejar");
    }

    @Override
    public void alimentar() {
         System.out.println("A comer vegetais");
    }

    @Override
    public void emitirSom() {
         System.out.println("Som de reptil");
    }
    
    
}
