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
        System.out.println("METHOD SAVE");
        String query = resourcer.getString("request.save");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, request.getCaptainId());
            statement.setString(2, request.getDatetime().toString());
            statement.setString(3, request.getStatus().toString());
            statement.setString(4, request.getType().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer requestId) {
        String query = resourcer.getString("request.delete");

        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, requestId);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CaptainRequest request) {
//        String query = resourcer.getString("request.update");
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, request.getStatus().toString());
//            statement.setInt(2, request.getId());
//
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
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
    public CaptainRequest findCurrentRequestByCaptain(Integer captainId) {
        String query = ProjectResourcer.getInstance().getString("request.find.by.captain");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, captainId);
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
    public List<User> findAllCaptainList() {
        return null;
    }

    @Override
    public List<User> findAllDispatcherList() {
        return null;
    }
}
