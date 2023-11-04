package pp_fp08.stand;

import pp_fp08.stand.Enums.*;

public class Reboque extends Trailer{
    private TipologiaT tipologia;

    public Reboque(TipologiaT tipologia, int capacidade) {
        super(capacidade);
        this.tipologia = tipologia;
    }

    public TipologiaT getTipologia() {
        return tipologia;
    }

    public void setTipologia(TipologiaT tipologia) {
        this.tipologia = tipologia;
    }
    
}
