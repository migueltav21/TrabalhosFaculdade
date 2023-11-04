
import java.util.Calendar;

public class JumbHipermarket extends Hipermarket{

    public JumbHipermarket(String name, int vatNumber, double annualRate, double gasPrice, double coffeePrice, double potatosPrice) {
        super(name, vatNumber, annualRate, gasPrice, coffeePrice, potatosPrice);
    }
  
    public int getPoints(double total){
        int pontos;
         Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek > 1 && dayOfWeek < 7) {
        pontos = ((int)(total / 10)) * 3;
    }else{
            pontos = ((int)(total / 10));
        }
        return pontos;
    }
    
}
