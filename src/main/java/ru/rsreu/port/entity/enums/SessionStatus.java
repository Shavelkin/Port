package ru.rsreu.port.entity.enums;

public enum SessionStatus {
    AUTHORIZED("Авторизован"),
    NOT_AUTHORIZED( "Не авторизован");
    private String name;

    SessionStatus(String name) {
        this.name = name;
    }
    public String getRussianName() {
        return name;
    }
}
