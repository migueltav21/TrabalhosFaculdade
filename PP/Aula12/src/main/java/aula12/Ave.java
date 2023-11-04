package aula12;

public class Ave extends Animal{
    private String corPena;

    public Ave(String corPena, float peso, int idade, int membros) {
        super(peso, idade, membros);
        this.corPena = corPena;
    }

    public String getCorPena() {
        return corPena;
    }

    public void setCorPena(String corPena) {
        this.corPena = corPena;
    }

    @Override
    public void locomover() {
       System.out.println("Avoar");  
    }

    @Override
    public void alimentar() {
        System.out.println("A  comer frutas");
    }

    @Override
    public void emitirSom() {
         System.out.println("Som de ave");
    }
    
    public void fazerNinho(){
         System.out.println("A fazer um ninho");
    }
    
}
