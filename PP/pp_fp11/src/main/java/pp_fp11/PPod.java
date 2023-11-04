package pp_fp11;

import pp_fp11.Enums.Extensao;

public class PPod implements Funcionalidades {

    private int espacoMemoria = 100;
    private Ficheiro[] ficheiro;
    int index;

    public PPod(Ficheiro[] ficheiro) {
        this.ficheiro = new Ficheiro[20];
        this.ficheiro = ficheiro;
    }

    public int getEspacoMemoria() {
        return espacoMemoria;
    }

    public void setEspacoMemoria(int espacoMemoria) {
        this.espacoMemoria = espacoMemoria;
    }

    public Ficheiro[] getFicheiro() {
        return ficheiro;
    }

    public void setFicheiro(Ficheiro[] ficheiro) {
        this.ficheiro = ficheiro;
    }

    @Override
    public void addFile(Ficheiro file) {
        if (this.ficheiro.length < 20 && (file.getExtensao() == Extensao.MP3)) {
            Ficheiro[] newArray = new Ficheiro[this.ficheiro.length + 1];

            for (int i = 0; i < this.ficheiro.length; i++) {
                newArray[i] = this.ficheiro[i];
            }

            newArray[newArray.length - 1] = file;
            this.setFicheiro(newArray);
            System.out.println("Ficheiro adiionado com sucesso");
        } else {
            System.out.println("Não é permitido adicionar o ficheiro");
        }
    }

    @Override
    public void deleteFile(int index) {
        try {
            Ficheiro[] newArray = new Ficheiro[this.ficheiro.length - 1];
            for (int i = 0; i < index; i++) {
                newArray[i] = this.ficheiro[i];
            }
            for (int i = index; i < newArray.length; i++) {
                newArray[i] = this.ficheiro[i + 1];
            }
            this.setFicheiro(newArray);
            System.out.println("Ficheiro removido com suceso");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Não é possível remover este ficheiro\n" + e.getMessage());
        }
    }

    @Override
    public void playTrack(int index) {
        try {
            this.index = index;
            System.out.println("A tocar : " + this.ficheiro[index].getNome() + " com duração de " + this.ficheiro[index].getDuracao() + " segundos");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Não é possível remover este ficheiro\n" + e.getMessage());
        }
    }

    @Override
    public void nextTrack() {
        System.out.println("A tocar : " + this.ficheiro[this.index + 1].getNome() + " com duração de " + this.ficheiro[this.index + 1].getDuracao() + " segundos");

    }

    @Override
    public void previousTrack() {
        System.out.println("A tocar : " + this.ficheiro[this.index - 1].getNome() + " com duração de " + this.ficheiro[this.index - 1].getDuracao() + " segundos");
    }

    @Override
    public String toString() {
        return "PPod{" + "espacoMemoria=" + espacoMemoria + ", ficheiro=" + ficheiro + '}';
    }

}
