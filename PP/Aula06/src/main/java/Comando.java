
public class Comando implements Contolador {

    private int volume;
    private boolean ligado;
    private boolean tocando;

    //Metodo construtor
    public Comando() {
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }

    //getters e setters
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean isTocando() {
        return tocando;
    }

    public void setTocando(boolean tocando) {
        this.tocando = tocando;
    }

    //metodos abstratos
    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
          if(this.isLigado()== false){
            this.setTocando(false);
        }
        System.out.println("Está ligado?" + this.isLigado());
        System.out.println("Está a tocar?" + this.isTocando());
        if(this.isLigado() == false){
            this.setVolume(0);
        }
        System.out.println("Volume: " + this.getVolume());
        for (int i = 0; i <= this.getVolume(); i += 10) {
            System.out.print("|");

        }
    }

    @Override
    public void fecharMnu() {
        System.out.println("Menu fechado");
    }

    @Override
    public void maisVolume() {
        if (this.isLigado()) {
            this.setVolume(this.getVolume() + 1);
        }
    }

    @Override
    public void menosVolume() {
        if (this.isLigado()) {
            this.setVolume(this.getVolume() - 1);
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getVolume() > 0 && this.isLigado() ) {
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
         if (this.getVolume() == 0 && this.isLigado() ) {
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if(this.isLigado() && !(this.isTocando())){
            this.setTocando(true);
        }
    }

    @Override
    public void pause() {
        if(this.isLigado() && this.isTocando()){
            this.setTocando(false);
        }
    }

}
