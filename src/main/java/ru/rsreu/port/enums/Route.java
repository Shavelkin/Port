package ru.rsreu.port.enums;

public enum Route {

    LOGIN("/login"),
    LOGOUT("/login"),

    ADMIN_PROFILE("/adminProfile"),

    DISPATCHER_PROFILE("/dispatcherProfile"),

    CAPTAIN_PROFILE("/captainProfile"),
    CREATE_REQUEST("/createRequest"),
    USER_LIST("/userList"),
    INFORM_ABOUT_MOVEMENT("/informAboutMovement"),
    CANCEL_REQUEST("/cancelRequest"),
    APPROVE_REQUEST("/approveRequest"),
    REJECT_REQUEST("/rejectRequest"),

    ACTIVE_REQUEST_LIST("/activeRequestList"),

    WAITING_REQUEST_LIST("/waitingRequestList"),

    ADD_USER("/addUser"),
    DELETE_USER("/deleteUser"),
    CHANGE_USER("/changeUser"),

    INFO_CURRENT_REQUEST("/infoCurrentRequest"),
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
