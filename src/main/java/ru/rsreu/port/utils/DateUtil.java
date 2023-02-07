package ru.rsreu.port.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy H:m");

    public static java.sql.Date parse(String date) {
        Date result;
        try {
            result = dateFormat1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        return new java.sql.Date(result.getTime());
    }

    public static String  getCurrentDate() {
//        return "24-JAN-12 05.57.12.002648 AM";
        return dateFormat1.format(new Date());
    }
}
