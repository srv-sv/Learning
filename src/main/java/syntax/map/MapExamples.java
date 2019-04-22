package syntax.map;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class MapExamples {
    public static void main(String[] args) {
    }

    public static void removeAllEntriesForJanuary(HashMap<String, Date> map, int month) {
        Calendar calendar = Calendar.getInstance();

        map
                .values()
                .removeIf(value -> {
                    calendar.setTime(value);
                    return (calendar.get(Calendar.MONTH) == month);
                });
    }
}