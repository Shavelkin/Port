package ru.rsreu.port.database.impl;

import ru.rsreu.port.database.AbstractDAO;
import ru.rsreu.port.database.dao.CaptainRequestDAO;
import ru.rsreu.port.entity.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CaptainRequestDAOImpl extends AbstractDAO implements CaptainRequestDAO {
    @Override
    public void save(CaptainRequest request) {
//        String query = resourcer.getString("request.save");
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, request.getPassenger().getUserId());
//            statement.setInt(2, request.getTrip().getTripId());
//            statement.setString(3, request.getRequestStatus().toString());
//
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void delete(Integer requestId) {

    }

    @Override
    public void update(CaptainRequest request) {

    }

    @Override
    public CaptainRequest findById(Integer requestId) {
        return null;
    }

    @Override
    public List<CaptainRequest> findAllRequests() {
        return null;
    }

    @Override
    public List<CaptainRequest> findActiveRequests() {
        return null;
    }

    @Override
    public List<CaptainRequest> findWaitingRequests() {
        return null;
    }

    @Override
    public List<Pier> findFreePiers() {
        return null;
    }

    @Override
    public List<Pier> findBusyPiers() {
        return null;
    }

    @Override
    public List<Pilot> findFreePilotList() {
        return null;
    }

    @Override
    public Ship findShipByCaptainId(Integer captainId) {
        return null;
    }

    @Override
    public CaptainRequest findRequestByShipId(Integer shipId) {
        return null;
    }

    @Override
    public List<User> findAllCaptainList() {
        return null;
    }

    @Override
    public List<User> findAllDispatcherList() {
        return null;
    }
}
