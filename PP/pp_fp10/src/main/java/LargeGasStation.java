/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class LargeGasStation extends GasStation implements CoffeeService{
    private double coffePrice;

    public LargeGasStation(double coffePrice, double gasPrice, String name, int vatNumber) {
        super(gasPrice, name, vatNumber);
        this.coffePrice = coffePrice;
    }

    public LargeGasStation(double coffePrice, String name, int vatNumber) {
        super(name, vatNumber);
        this.coffePrice = coffePrice;
    }

    
    
    @Override
    public double getCoffeePrice() {
        return this.coffePrice;
    }

    @Override
    public void setCoffePrice(double p) {
        if(p >0){
            this.coffePrice = p;
        }else{
            System.out.println("Não é possível alterar o "
                    + "preço do café");
        }
    }

    @Override
    public double getCoffeTotal(int p) {
        double total = 0;
        if(p > 0){
            total = p * this.getCoffeePrice();
        }
        return total;
    }
    
    
}
