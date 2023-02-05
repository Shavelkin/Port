package ru.rsreu.port.service;

public class ServiceFactory {
    public static UserService getUserService() {return UserService.getInstance();}
    public static CaptainRequestService getCaptainRequestServive() {return CaptainRequestService.getInstance();}

    public static SessionService getSessionService() {return SessionService.getInstance();}
}
