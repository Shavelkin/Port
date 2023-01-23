package ru.rsreu.port.entity.enums;

public enum Roles {
<<<<<<< HEAD
=======

>>>>>>> origin/master
    ADMIN("ADMIN"),
    DISPATCHER("DISPATCHER"),
    CAPTAIN("CAPTAIN");

    private String  role;

    Roles(String role) {
        this.role = role;
    }

    public String getRussianName() {
        switch (role) {
            case "ADMIN": return "Администратор";
            case "DISPATCHER": return "Диспетчер";
            case "CAPTAIN": return "Капитан";
        }
        return null;
    }
}
