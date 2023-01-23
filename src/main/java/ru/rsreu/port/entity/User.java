package ru.rsreu.port.entity;

import ru.rsreu.port.entity.enums.Roles;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private Roles userRole;
}
