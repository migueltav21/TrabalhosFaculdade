package pp_fp08.stand;

public class SemiReboque extends Trailer{
    private int numPneusSub;

    public SemiReboque(int numPneusSub, int capacidade) {
        super(capacidade);
        this.numPneusSub = numPneusSub;
    }

    public int getNumPneusSub() {
        return numPneusSub;
    }

    public void setNumPneusSub(int numPneusSub) {
        this.numPneusSub = numPneusSub;
    }
    
}
