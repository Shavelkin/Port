package ru.rsreu.port.utils;

import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.enums.Roles;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class UserUtil {
    private static final String USER_ID = "user_id";
    private static final int COOKIE_MAX_AGE = 60 * 60;

    private UserUtil() {
    }

    public static Optional<User> getFromRequest(HttpServletRequest request) {
        User user = (User)request.getUserPrincipal();

        return Optional.ofNullable(user);
    }

    public static User tryGetFromRequest(HttpServletRequest request) {
        return getFromRequest(request).orElseThrow(RuntimeException::new);
    }

    public static Cookie createUserCookie(User user) {
        Cookie cookie = new Cookie(USER_ID, user.getUserId().toString());

        cookie.setMaxAge(COOKIE_MAX_AGE);

        return cookie;
    }

    public static Optional<Integer> getUserIdFromCookies(Cookie[] cookies) {
        if (cookies == null) {
            return Optional.empty();
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(USER_ID)) {
                String value = cookie.getValue();

                return value == null
                        ? Optional.empty()
                        : Optional.of(Integer.parseInt(value));
            }
        }

        return Optional.empty();
    }
    public static String getNameRequestByRole(Roles role){
        switch (role) {
            case ADMIN: return "admin.add";
            case CAPTAIN: return "captain.add";
            case DISPATCHER: return "dispatcher.add";
        }
        return null;
    }

    public static String getDeleteRequestByRole(Roles role){
        switch (role) {
            case ADMIN: return "admin.delete";
            case CAPTAIN: return "captain.delete";
            case DISPATCHER: return "dispatcher.delete";
        }
        return null;
    }

    public static String getUpdateRequestByRole(Roles role){
        switch (role) {
            case ADMIN: return "admin.update";
            case CAPTAIN: return "captain.update";
            case DISPATCHER: return "dispatcher.update";
        }
        return null;
    }
}

