package ru.rsreu.port.enums;

public enum Jsp {
    LOGIN("/jsp/login.jsp"),

    ADMIN_PROFILE("/jsp/adminProfile.jsp"),

    DISPATCHER_PROFILE("/jsp/dispatcherProfile.jsp"),

    CAPTAIN_PROFILE("/jsp/captainProfile.jsp"),
    NOT_FOUND("/jsp/adminProfile.jsp");
    private final String route;

    Jsp(String route) {
        this.route = route;
    }

    public String getRoute() {
        return this.route;
    }
}
