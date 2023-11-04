
public class Caneta {

    private String modelo;
    private float ponta;
    private boolean tampada;
    private String cor;

    public Caneta(String modelo, float ponta, boolean tampada, String cor) {
        this.modelo = modelo;
        this.ponta = ponta;
        this.tampada = tampada;
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPonta() {
        return ponta;
    }

    public void setPonta(float ponta) {
        this.ponta = ponta;
    }

    public boolean isTampada() {
        return tampada;
    }

    public void setTampada(boolean tampada) {
        this.tampada = tampada;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public Caneta(){
        this.tapar();
        this.cor = "Azul";
    }
    

    public void tapar(){
        this.tampada = true;
    }
    
    public void destapar(){
        this.tampada = false;
    }
    
    
    public void status(){
        System.out.println("Sobre a caneta:");
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Ponta:"+ this.getPonta());
                System.out.println("Cor: " + this.cor);
                        System.out.println("Esta tapada? " + this.tampada);
    }
}
