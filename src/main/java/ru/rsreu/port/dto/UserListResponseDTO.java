package ru.rsreu.port.dto;

import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.enums.SessionStatus;

import java.sql.Date;

public class UserListResponseDTO {
    private Integer session_id;
    private User user;
    private Date activeUntil;
    private SessionStatus status;
}
