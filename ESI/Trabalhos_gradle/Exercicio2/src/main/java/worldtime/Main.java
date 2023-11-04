package worldtime;

public class Main {
    public static void main(String[] args) {
        String country = "Portugal"; 
        String time = WorldTime.getTimeByCountry(country);
        System.out.println("Hora em " + country + ": " + time);
    }
}
