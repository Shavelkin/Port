package ru.rsreu.port.entity;

import ru.rsreu.port.entity.enums.Roles;
import java.security.Principal;

public class User {
    private Integer userId;
    private String name;
    private String login;
    private String password;
    private Roles userRole;

    public Integer getUserId() {
        return this.userId;
    }
}
