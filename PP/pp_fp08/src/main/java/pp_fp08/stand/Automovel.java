package pp_fp08.stand;

import pp_fp08.stand.Enums.*;

public class Automovel extends Veiculo {

    private int numOcupantes;
    private int numPortas;
       
    public Automovel(int numOcupantes, int numChassis, String marca, String modelo, String dataDeFabrico, Enums.Origem origem, float Kms, Enums.Condicao condicao, int preco) {
        super(numChassis, marca, modelo, dataDeFabrico, origem, Kms, condicao, preco);
        this.numOcupantes = numOcupantes;
        this.numPortas = 3;
        this.setPreco(preco);
    }
    
    public int getNumOcupantes() {
        return numOcupantes;
    }
    
    public void setNumOcupantes(int numOcupantes) {
        this.numOcupantes = numOcupantes;
    }
    
    public int getNumPortas() {
        return numPortas;
    }
    
    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }
    
   
    
    @Override
    public void setPreco(int preco) {
        if (this.getCondicao() == Condicao.NOVO) {
            super.setPreco(preco);            
        } else {
            super.setPreco((int) (preco * (0.7)));
        }
        
    }
    
    @Override
    public String toString() {
        return "Automovel:" + "numOcupantes=" + numOcupantes + ", numPortas=" + numPortas + ", id=" + this.getId() + ", numChassis=" + this.getNumChassis() + ", modelo=" + this.getModelo() + ", dataDeFabrico=" + this.getDataDeFabrico() + ", origem=" + this.getOrigem() + ", Kms=" + this.getKms() + ", condicao=" + this.getCondicao() + ", preco=" + this.getPreco() + " euros";
    }
    
}
