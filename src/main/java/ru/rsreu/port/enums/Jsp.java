package ru.rsreu.port.enums;

public enum Jsp {
    LOGIN("/jsp/login.jsp"),
    ADMIN_PROFILE("/jsp/admin/adminProfile.jsp"),
    DISPATCHER_PROFILE("/jsp/dispatcher/dispatcherProfile.jsp"),
    CAPTAIN_PROFILE("/jsp/captain/captainProfile.jsp"),
    CREATE_REQUEST("/jsp/captain/createRequest.jsp"),
    USER_LIST("/jsp/userList.jsp"),

    ACTIVE_REQUEST_LIST("/jsp/activeRequestList.jsp"),

    WAITING_REQUEST_LIST("/jsp/waitingRequestList.jsp"),

    ADD_USER("/jsp/admin/addUser.jsp"),
    DELETE_USER("/jsp/admin/deleteUser.jsp"),
    CHANGE_USER("/jsp/admin/changeUser.jsp"),
    APPROVE_REQUEST("/jsp/dispatcher/approveRequest.jsp"),
    REJECT_REQUEST("/jsp/dispatcher/rejectRequest.jsp"),

    INFO_CURRENT_REQUEST("/jsp/captain/infoCurrentRequest.jsp"),
    NOT_FOUND("/jsp/404.jsp");
    private final String route;

    Jsp(String route) {
        this.route = route;
    }

    public String getRoute() {
        return this.route;
    }
}
