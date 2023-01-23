package ru.rsreu.port.enums;

public enum Jsp {
    LOGIN("/jsp/login.jsp"),

    NOT_FOUND("/pages/404.jsp");
    private final String route;

    Jsp(String route) {
        this.route = route;
    }

    public String getRoute() {
        return this.route;
    }
}