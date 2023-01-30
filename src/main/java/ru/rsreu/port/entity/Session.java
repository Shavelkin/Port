package ru.rsreu.port.entity;

import java.sql.Date;

public class Session {
    private Integer session_id;
    private User user;
    private Date activeUntil;

    public Session(User user, Date activeUntil) {
        this.user = user;
        this.activeUntil = activeUntil;
    }

    public Date getActiveUntil() {
        return this.activeUntil;
    }

    public Integer getSession_id() {
        return this.session_id;
    }

    public User getUser() { return this.user; }
}
