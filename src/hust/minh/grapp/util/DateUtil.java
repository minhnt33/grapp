package hust.minh.grapp.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Helper functions for handling dates.
 */
public class DateUtil {
    private static final String DATE_PATTERN = "dd.MM.yyyy";

    private static final DateTimeFormatter DATE_FORMATER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATER.format(date);
    }

    public static LocalDate parse(String dateStr) {
        try {
            return DATE_FORMATER.parse(dateStr, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static boolean validDate(String dateStr)
    {
        return parse(dateStr) != null;
    }
}
