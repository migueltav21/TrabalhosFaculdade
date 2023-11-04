package pp_fp08.stand;

public class Motociclo extends Veiculo{
    private int cilindrada;
    private float diamtroRodas;

    public Motociclo(int cilindrada, float diamtroRodas, int numChassis, String marca, String modelo, String dataDeFabrico, Enums.Origem origem, float Kms, Enums.Condicao condicao, int preco) {
        super(numChassis,marca, modelo, dataDeFabrico, origem, Kms, condicao, preco);
        this.cilindrada = cilindrada;
        this.diamtroRodas = diamtroRodas;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public float getDiamtroRodas() {
        return diamtroRodas;
    }

    public void setDiamtroRodas(float diamtroRodas) {
        this.diamtroRodas = diamtroRodas;
    }

    @Override
    public String toString() {
        return "Motociclo:" + "cilindrada=" + cilindrada + ", diamtroRodas=" + diamtroRodas + ", id=" + this.getId() + ", numChassis=" + this.getNumChassis() + ", modelo=" + this.getModelo() + ", dataDeFabrico=" + this.getDataDeFabrico() + ", origem=" + this.getOrigem() + ", Kms=" + this.getKms() + ", condicao=" + this.getCondicao() + ", preco=" + this.getPreco() + " euros";
    }
    
    
}
