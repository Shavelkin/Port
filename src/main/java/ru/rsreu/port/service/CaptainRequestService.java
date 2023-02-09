package ru.rsreu.port.service;

import ru.rsreu.port.database.DAOFactory;
import ru.rsreu.port.database.dao.CaptainRequestDAO;
import ru.rsreu.port.entity.CaptainRequest;

import java.util.List;

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
    public void changeStatusToCompleted(Integer id) {
        captainRequestDAO.changeStatusToCompleted(id);
    }

    public void changeStatusToCancelled(Integer id) {
        captainRequestDAO.changeStatusToCompleted(id);
    }

    public void createRequest(CaptainRequest request) {
        captainRequestDAO.save(request);
    }

    public Integer findNumberRequestByCaptain(Integer captainId) {
        return captainRequestDAO.findNumberRequestByCaptain(captainId);
    }
    public CaptainRequest findCurrentRequestByCaptain(Integer captainId) {
        return captainRequestDAO.findCurrentRequestByCaptain(captainId);
    }

//    public void deleteRequest(Integer requestId) {

//        CaptainRequest request = CaptainRequestDAOImpl.findById(requestId);
//        if (request.getStatus().equals(CaptainRequestStatus.APPROVED) && !request.getTrip().getTripStatus().equals(TripStatus.COMPLETED)) {
//            Trip trip = request.getTrip();
//            tripDAO.update(trip.setFreeSeats(trip.getFreeSeats()+1));
//        }
//        requestDAO.delete(requestId);
//    }

    public List<CaptainRequest> getWaitingRequests(){
        return captainRequestDAO.findWaitingRequests();
    }

    public List<CaptainRequest> getActiveRequests(){
        return captainRequestDAO.findActiveRequests();
    }

}
