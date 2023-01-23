package ru.rsreu.port.entity;

import ru.rsreu.port.entity.enums.CaptainRequestStatus;
import ru.rsreu.port.entity.enums.Type;

import java.util.Date;

public class CaptainRequest {
    private int id;
    private User dispatcher;
    private Ship ship;
    private Pier pier;
    private Date datetime;
    private CaptainRequestStatus status;
    private Type type;
}
