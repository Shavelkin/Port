package ru.rsreu.port.entity;

import ru.rsreu.port.entity.enums.CaptainRequestStatus;
import ru.rsreu.port.entity.enums.Type;

import java.util.Date;

public class CaptainRequest {
    private Integer id;
    private Integer captainId;

    private Integer pierId;
    private Date datetime;
    private CaptainRequestStatus status;
    private Type type;

    public CaptainRequest(Integer id, Integer captainId, Integer pierId, Date datetime, CaptainRequestStatus status, Type type) {
        this.id = id;
        this.captainId = captainId;
        this.pierId = pierId;
        this.datetime = datetime;
        this.status = status;
        this.type = type;
    }
}
