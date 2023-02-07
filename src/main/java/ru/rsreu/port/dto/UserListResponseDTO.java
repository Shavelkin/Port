package ru.rsreu.port.dto;

import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.enums.SessionStatus;

import java.sql.Date;

public class UserListResponseDTO {
    private Integer session_id;
    private User user;
    private Date activeUntil;
    private SessionStatus status;

    public UserListResponseDTO(Integer session_id, User user, Date activeUntil, SessionStatus status) {
        this.session_id = session_id;
        this.user = user;
        this.activeUntil = activeUntil;
        this.status = status;
    }

    public User getUser() {
        return user;
    }
}
