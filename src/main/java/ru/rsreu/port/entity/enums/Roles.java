package ru.rsreu.port.entity.enums;

public enum Roles {

    ADMIN("ADMIN"),
    DISPATCHER("DISPATCHER"),
    CAPTAIN("CAPTAIN"),

    UNKNOWN("UNKNOWN");

    private final String  role;

    Roles(String role) {
        this.role = role;
    }

    public String getRussianName() {
        switch (role) {
            case "ADMIN": return "Администратор";
            case "DISPATCHER": return "Диспетчер";
            case "CAPTAIN": return "Капитан";
        }
        return "Инкогнито";
    }
}

