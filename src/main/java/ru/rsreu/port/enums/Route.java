package ru.rsreu.port.enums;

public enum Route {

    LOGIN("/login"),
    LOGOUT("/login"),

    ADMIN_PROFILE("/adminProfile"),

    DISPATCHER_PROFILE("/dispatcherProfile"),

    CAPTAIN_PROFILE("/captainProfile"),

    NOT_FOUND("404");
    private final String route;

    Route(String route) {
        this.route = route;
    }

    public String getRelative() {
        return this.route;
    }

    public String getAbsolute() {
        return this.route.substring(1);
    }

}
