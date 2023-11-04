package aula12;

public class Peixe extends Animal{
    private String corEscama;

    public Peixe(String corEscama, float peso, int idade, int membros) {
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
        System.out.println("A nadar");
    }

    @Override
    public void alimentar() {
        System.out.println("A comer placton");
    }

    @Override
    public void emitirSom() {
         System.out.println("Peixe não emite som.");
    }
    
    public void soltarBolhas(){
         System.out.println("A soltar bolhas");
    }
    
}
