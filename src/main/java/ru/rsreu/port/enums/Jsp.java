package ru.rsreu.port.enums;

public enum Jsp {
    LOGIN("/jsp/login.jsp"),
    ADMIN_PROFILE("/jsp/admin/adminProfile.jsp"),
    DISPATCHER_PROFILE("/jsp/dispatcher/dispatcherProfile.jsp"),
    CAPTAIN_PROFILE("/jsp/captain/captainProfile.jsp"),
    CREATE_REQUEST("/jsp/captain/createRequest.jsp"),
    NOT_FOUND("/jsp/404.jsp");
    private final String route;

    Jsp(String route) {
        this.route = route;
    }

    public String getRoute() {
        return this.route;
    }
}
