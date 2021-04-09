package be.cyimena.airbnb.assetsservice.tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateChecker {

    public static boolean isValidDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            LocalDateTime.parse(date, formatter);
            return true;
        } catch (DateTimeParseException pe) {
            return false;
        }
    }

    public LocalDateTime convertToDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException pe) {
            return null;
        }
    }

}
