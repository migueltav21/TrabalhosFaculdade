package worldtime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class WorldTime {
    public static String getTimeByCountry(String country) {
        DateTimeZone zone = DateTimeZone.forID(country);
        DateTime dateTime = new DateTime(zone);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        return dateTime.toString(formatter);
    }
}
