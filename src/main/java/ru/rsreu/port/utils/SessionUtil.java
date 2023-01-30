package ru.rsreu.port.utils;

import ru.rsreu.port.entity.Session;

import java.util.Date;

public class SessionUtil {
    private SessionUtil() {
    }

    public static boolean checkValid(Session session) {
        Date currentDate = new Date();
        Date sessionExpiredDate = session.getActiveUntil();

        return sessionExpiredDate.after(currentDate);
    }
}
