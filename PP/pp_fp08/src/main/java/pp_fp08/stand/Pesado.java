package pp_fp08.stand;

import pp_fp08.stand.Enums.*;

public class Pesado extends Veiculo {

    private float comprimento;
    private int cargaUtil;
    private Tipologia tipologia;
    private boolean trailer;

    public Pesado(float comprimento, int cargaUtil, Tipologia tipologia, boolean trailer, int numChassis, String marca, String modelo, String dataDeFabrico, Enums.Origem origem, float Kms, Enums.Condicao condicao, int preco) {
        super(numChassis, marca, modelo, dataDeFabrico, origem, Kms, condicao, preco);
        this.comprimento = comprimento;
        this.cargaUtil = cargaUtil;
        this.tipologia = tipologia;
        this.trailer = trailer;
        this.setPreco(preco);
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public int getCargaUtil() {
        return cargaUtil;
    }

    public void setCargaUtil(int cargaUtil) {
        this.cargaUtil = cargaUtil;
    }

    public Tipologia getTipologia() {
        return tipologia;
    }

    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }

    public boolean isTrailer() {
        return trailer;
    }

    public void setTrailer(boolean trailer) {
        this.trailer = trailer;
    }

    @Override
    public void setPreco(int preco) {
        if (this.getCondicao() == Condicao.NOVO && this.isTrailer() == true) {
            super.setPreco((int) (preco * 0.95));
        } else if (this.getCondicao() == Condicao.NOVO && this.isTrailer() == false) {
            super.setPreco(preco);
        }else{
            super.setPreco((int) (preco * 0.85));
        }
    }

    @Override
    public String toString() {
        return "Veiculo Pesado:" + "comprimento=" + comprimento + " metros, cargaUtil=" + cargaUtil + " kilos, tipologia=" + tipologia + ", trailer=" + trailer + ", id=" + this.getId() + ", numChassis=" + this.getNumChassis() + ", modelo=" + this.getModelo() + ", dataDeFabrico=" + this.getDataDeFabrico() + ", origem=" + this.getOrigem() + ", Kms=" + this.getKms() + ", condicao=" + this.getCondicao() + ", preco=" + this.getPreco() + " euros";
    }

}
