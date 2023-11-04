package pp_fp08.stand;

import pp_fp08.stand.Enums.*;



public class Veiculo {
private int id;
private int numChassis;
private String marca;
private String modelo;
private String dataDeFabrico;
private Origem origem;
private float Kms;
private Condicao condicao;
private int preco;

    public Veiculo(int numChassis,String marca, String modelo, String dataDeFabrico, Origem origem, float Kms, Condicao condicao, int preco) {
        this.numChassis = numChassis;
        this.marca = marca;
        this.modelo = modelo;
        this.dataDeFabrico = dataDeFabrico;
        this.origem = origem;
        this.Kms = Kms;
        this.condicao = condicao;
        this.preco = preco;
        //Qnd o veículo é criado ele n tem id pq n pertence ao stand
        this.id = 0;
    }    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumChassis() {
        return numChassis;
    }

    public void setNumChassis(int numChassis) {
        this.numChassis = numChassis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDataDeFabrico() {
        return dataDeFabrico;
    }

    public void setDataDeFabrico(String dataDeFabrico) {
        this.dataDeFabrico = dataDeFabrico;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public float getKms() {
        return Kms;
    }

    public void setKms(float Kms) {
        this.Kms = Kms;
    }

    public Condicao getCondicao() {
        return condicao;
    }

    public void setCondicao(Condicao condicao) {
        this.condicao = condicao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
    

    @Override
    public String toString() {
        return "Veiculo:" + "id=" + id + ", numChassis=" + numChassis + ", modelo=" + modelo + ", dataDeFabrico=" + dataDeFabrico + ", origem=" + origem + ", Kms=" + Kms + ", condicao=" + condicao + ", preco=" + preco + " euros";
    }
    
    
}
