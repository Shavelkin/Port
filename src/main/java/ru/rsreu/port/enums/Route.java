package ru.rsreu.port.enums;

public enum Route {

    LOGIN("/login"),

    ADMIN_PROFILE("/adminProfile"),

    DISPATCHER_PROFILE("/dispatcherProfile"),

    CAPTAIN_PROFILE("/captainProfile");
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
