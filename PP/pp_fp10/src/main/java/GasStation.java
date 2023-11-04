
public class GasStation extends Company implements GasService {

    private double gasPrice;

    public GasStation(double gasPrice, String name, int vatNumber) {
        super(name, vatNumber);
        this.gasPrice = gasPrice;
    }
    
    public GasStation(String name, int vatNumber) {
        super(name, vatNumber);
    }

    @Override
    public double getGasPrice() {
        return this.gasPrice;
    }

    @Override
    public void setGasPrice(double p) {
        if (p >= 0) {
            this.gasPrice = p;
        } else {
            System.out.println("Não é possível alterar o preço"
                    + "da gasolina");
        }
    }

    @Override
    public double getGasTotal(double litros) {
        double total = 0;
        if (litros > 0) {
            total = litros * this.getGasPrice();
        }
        return total;
    }
    
    public GasStation cheapestGasStation(GasStation[] bombas){
        GasStation bombaMaisBarata = bombas[0];
        for(GasStation gasStation : bombas){
            if(gasStation.getGasPrice() < bombaMaisBarata.getGasPrice()){
                bombaMaisBarata = gasStation;
            }
        }
        return bombaMaisBarata;
    } 
}
