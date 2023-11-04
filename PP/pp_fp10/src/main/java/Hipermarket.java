
import java.util.Calendar;

public class Hipermarket extends Supermarket implements HipermarketService {

    private double annualRate;
    private double gasPrice;
    private double coffeePrice;

    public Hipermarket(String name, int vatNumber, double annualRate, double gasPrice, double coffeePrice, double potatosPrice) {
        super(potatosPrice, name, vatNumber);
        this.annualRate = annualRate;
        this.gasPrice = gasPrice;
        this.coffeePrice = coffeePrice;
    }

    @Override
    public double getAnnualRate() {
        return this.annualRate;
    }

    @Override
    public void setAnnualRate(double r) {
        this.annualRate = r;
    }

    @Override
    public double computemonthyPayment(double ammount, int months) {
        double taxaJuroMensal = Math.pow(this.getAnnualRate(), 1 / 12);
        double prestacaoMensal = (taxaJuroMensal * ammount) / (1 - (Math.pow(1 + taxaJuroMensal, -months)));
        return prestacaoMensal;
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

    @Override
    public double getCoffeePrice() {
        return this.coffeePrice;
    }

    @Override
    public void setCoffePrice(double p) {
        if (p > 0) {
            this.coffeePrice = p;
        } else {
            System.out.println("Não é possível alterar o "
                    + "preço do café");
        }
    }

    @Override
    public double getCoffeTotal(int p) {
        double total = 0;
        if (p > 0) {
            total = p * this.getCoffeePrice();
        }
        return total;
    }

    public void HipermercadoMaisPintos(double total) {
        int pontos1, pontos2 = 0;
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        if (dayOfMonth >= 20) {
            pontos1 = (int) (total / 5);
        } else {
            pontos1 = ((int) (total / 20)) * 3;
        }

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek > 1 && dayOfWeek < 7) {
            pontos2 = ((int) (total / 10)) * 3;
        } else {
            pontos2 = ((int) (total / 10));
        }
        if (pontos1 > pontos2) {
            System.out.println("O hipermercado que atribui mais pontos é o Continente");
        } else {
            System.out.println("O hipermercado que atribui mais pontos é o Jumbo");
        }
    }

    public Hipermarket cabazMaisBarato(Hipermarket[] mercados){
        Hipermarket mercadoMaisBarato = mercados[0];
        int l = 30, c = 10, q = 5;
        double total = mercadoMaisBarato.getCoffeTotal(c) + mercadoMaisBarato.getGasTotal(l) + mercadoMaisBarato.getMarketTotal(q);
        for(Hipermarket hipermarket : mercados){
            if(hipermarket.getCoffeTotal(c) + hipermarket.getGasTotal(l) + hipermarket.getMarketTotal(q) < total){
                mercadoMaisBarato = hipermarket;
            }
        }
        return mercadoMaisBarato;
    }
    
}
