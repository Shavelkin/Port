package ru.rsreu.port.entity;

import ru.rsreu.port.entity.enums.Roles;
import java.security.Principal;
import javax.security.auth.Subject;

public class User implements Principal {
    private Integer userId;

    private String login;
    private String password;
    private String name;
    private Roles userRole;

    public User(Integer id,  String login, String password, String name, Roles userRole) {
        this.userId = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }

    public User(String login, String password, String name, Roles userRole) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.userRole = userRole;
    }

    public User(){
        this.userId = 0;
        this.name = "incognito";
        this.login = "incognito";
        this.password = "incognito";
        this.userRole = Roles.UNKNOWN;
    }
    public String getLogin() {
        return this.login;
    }

    public String getPassword() { return this.password; }

    public Integer getUserId() {
        return this.userId;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Roles getUserRole() {
        return userRole;
    }
}
