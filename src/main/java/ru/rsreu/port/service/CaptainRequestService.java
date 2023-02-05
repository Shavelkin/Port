package ru.rsreu.port.service;

import ru.rsreu.port.database.DAOFactory;
import ru.rsreu.port.database.dao.CaptainRequestDAO;
import ru.rsreu.port.database.dao.UserDAO;
import ru.rsreu.port.entity.CaptainRequest;

public class CaptainRequestService {
    private static CaptainRequestService instance;
    private final CaptainRequestDAO captainRequestDAO;
    public CaptainRequestService(CaptainRequestDAO captainRequestDAO) {
        this.captainRequestDAO = captainRequestDAO;
    }
    public static CaptainRequestService getInstance() {
        synchronized (SessionService.class) {
            if (instance == null) {
                instance = new CaptainRequestService(DAOFactory.getCaptainRequestDAO());
            }
        }
        return instance;
    }
}
