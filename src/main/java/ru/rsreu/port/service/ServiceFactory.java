package ru.rsreu.port.service;

public class ServiceFactory {
    public static UserService getUserService() {return UserService.getInstance();}
}
