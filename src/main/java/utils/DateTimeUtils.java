package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class DateTimeUtils {

    private void parseDate(String date) {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
                .appendPattern("[MMMM d uuuu]")
                .appendPattern("[MMM d uuuu]");
        DateTimeFormatter formatter = builder.toFormatter(Locale.ENGLISH);
        LocalDate parsedDate = LocalDate.parse(date, formatter);
    }
}