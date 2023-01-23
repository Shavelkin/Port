package ru.rsreu.port.entity;

import ru.rsreu.port.entity.enums.Roles;
import java.security.Principal;
import javax.security.auth.Subject;

public class User implements Principal {
    private Integer userId;
    private String name;
    private String login;
    private String password;
    private Roles userRole;

    public Roles getUserRole() {
        return userRole;
    }

    public User(Integer id, String name, String login, String password, Roles userRole) {
        this.userId = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }

    public String getLogin() {
        return login;
    }

    public Integer getUserId() {
        return this.userId;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
