package aula12;

public class NewMain {

    public static void main(String[] args) {
        //ERRO!
//Animal a = new Animal();
Mamifero m = new Mamifero("preto", 30.4f, 10, 4);
Reptil r = new Reptil("verde", 0.5f, 1, 5);
Peixe p = new Peixe("Azul", 1.2f, 1, 0);
Ave a = new Ave("Branco", 10.5f, 19, 4);

m.alimentar();
m.emitirSom();
m.locomover();

r.alimentar();
r.locomover();
r.emitirSom();

    }
    
}
