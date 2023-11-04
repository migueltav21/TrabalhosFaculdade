import java.util.Calendar;

public class ContinentHipermarket extends Hipermarket{
    
    public ContinentHipermarket(String name, int vatNumber, double annualRate, double gasPrice, double coffeePrice, double potatosPrice) {
        super(name, vatNumber, annualRate, gasPrice, coffeePrice, potatosPrice);
    }
    
    public int getPoints(double total){
        int pontos = 0;
        Calendar cal = Calendar.getInstance();
       int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
       if(dayOfMonth >= 20){
           pontos = (int) (total / 5);
       }else{
           pontos = ((int) (total / 20)) * 3;
       }
       return pontos;
    }
    
}
