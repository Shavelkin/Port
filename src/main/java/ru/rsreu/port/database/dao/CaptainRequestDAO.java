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
    Integer findNumberRequestByCaptain(Integer captainId);

    CaptainRequest findCurrentRequestByCaptain(Integer captainId);;
    void changeStatusToCompleted(Integer id);
    void changeStatusToCancelled(Integer id);
    void changeStatusToApproved(Integer id);
    void changeStatusToRejected(Integer id);
    void setPier(Integer idRequest, Integer idPier);
    void freePier(Integer idPier);
}
