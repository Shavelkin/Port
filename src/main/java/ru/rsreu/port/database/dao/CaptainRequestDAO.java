package ru.rsreu.port.database.dao;

import ru.rsreu.port.entity.*;

import java.util.List;

public interface CaptainRequestDAO {
    void save(CaptainRequest request);
    void delete(Integer requestId);
    void update(CaptainRequest request);
    CaptainRequest findById(Integer requestId);
    List<CaptainRequest> findAllRequests();
    List<CaptainRequest> findActiveRequests();
    List<CaptainRequest> findWaitingRequests();
    List<Pier> findFreePiers();
    List<Pier> findBusyPiers();
    List<Pilot> findFreePilotList();
    Ship findShipByCaptainId(Integer captainId);
    Integer findNumberRequestByCaptain(Integer captainId);

    CaptainRequest findCurrentRequestByCaptain(Integer captainId);
    void changeStatusToCompleted(Integer id);
    void changeStatusToCancelled(Integer id);

    List<User> findAllCaptainList();
    List<User> findAllDispatcherList();
}
