
public class Supermarket extends Company implements Marketservice {

    private double potatosPrice;

    public Supermarket(double potatosPrice, String name, int vatNumber) {
        super(name, vatNumber);
        this.potatosPrice = potatosPrice;
    }

    @Override
    public double getPotatoesPrice() {
        return this.potatosPrice;
    }

    @Override
    public void setPotatoesPrice(double p) {
        if (p > 0) {
            this.potatosPrice = p;
        } else {
            System.out.println("Não é possível alterar o "
                    + "preço das batatas");
        }
    }

    @Override
    public double getMarketTotal(double kilos) {
        double total = 0;
        if (kilos > 0) {
            total = kilos * this.getPotatoesPrice();
        }
        return total;
    }
}


