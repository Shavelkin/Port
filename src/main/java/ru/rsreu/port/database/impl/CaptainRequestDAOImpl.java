package ru.rsreu.port.database.impl;

import ru.rsreu.port.database.AbstractDAO;
import ru.rsreu.port.database.DAOMapper;
import ru.rsreu.port.database.dao.CaptainRequestDAO;
import ru.rsreu.port.entity.*;
import ru.rsreu.port.resourcer.ProjectResourcer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaptainRequestDAOImpl extends AbstractDAO implements CaptainRequestDAO {

    private static CaptainRequestDAOImpl instance;

    public static CaptainRequestDAOImpl getInstance() {
        synchronized (CaptainRequestDAOImpl.class) {
            if (instance == null) {
                instance = new CaptainRequestDAOImpl();
            }
        }
        return instance;
    }

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
        String query = ProjectResourcer.getInstance().getString("request.find.id");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, requestId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return DAOMapper.mapCaptainRequest(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CaptainRequest> findAllRequests() {
        String query = ProjectResourcer.getInstance().getString("request.find.all");
        List<CaptainRequest> requests = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                requests.add(DAOMapper.mapCaptainRequest(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<CaptainRequest> findActiveRequests() {
        String query = ProjectResourcer.getInstance().getString("request.find.active");
        List<CaptainRequest> requests = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                requests.add(DAOMapper.mapCaptainRequest(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CaptainRequest> findWaitingRequests() {
        String query = ProjectResourcer.getInstance().getString("request.find.waiting");
        List<CaptainRequest> requests = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                requests.add(DAOMapper.mapCaptainRequest(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
