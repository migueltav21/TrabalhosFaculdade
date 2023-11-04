public class NewMain {

    public static void main(String[] args) {
 GasStation g = new GasStation(2.5, "Bp", 1111111);
 System.out.println(g.getGasPrice());
 g.setGasPrice(2);
 System.out.println(g.getGasTotal(50));
 System.out.println("----------");
 LargeGasStation g2 = new LargeGasStation(0.7, 3, "Galp", 222222);
  System.out.println(g2.getGasPrice());
 System.out.println(g2.getGasTotal(50));
   System.out.println(g2.getCoffeePrice());
 System.out.println(g2.getCoffeTotal(50));
    }
    
}
