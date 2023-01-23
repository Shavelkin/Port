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

    public Integer getUserId() {
        return this.userId;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
