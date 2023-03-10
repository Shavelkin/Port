package ru.rsreu.port.entity;

import ru.rsreu.port.entity.enums.CaptainRequestStatus;
import ru.rsreu.port.entity.enums.Type;

import java.util.Date;

public class CaptainRequest {
    private Integer id;
    private Integer captainId;

    private Integer pierId;
    private String datetime;
    private CaptainRequestStatus status;
    private Type type;

    public CaptainRequest(Integer id, Integer captainId, Integer pierId, String datetime, CaptainRequestStatus status, Type type) {
        this.id = id;
        this.captainId = captainId;
        this.pierId = pierId;
        this.datetime = datetime;
        this.status = status;
        this.type = type;
    }

    public CaptainRequest() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getCaptainId() {
        return captainId;
    }
    public void setCaptainId(Integer captainId) {
        this.captainId = captainId;
    }

    public Integer getPierId() {
        return pierId;
    }

    public String getDatetime() {
        return datetime;
    }

    public CaptainRequestStatus getStatus() {
        return status;
    }

    public Type getType() {
        return type;
    }
}
