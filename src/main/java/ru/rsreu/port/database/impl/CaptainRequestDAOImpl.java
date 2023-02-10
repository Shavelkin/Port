package ru.rsreu.port.database.impl;

import ru.rsreu.port.database.AbstractDAO;
import ru.rsreu.port.database.DAOMapper;
import ru.rsreu.port.database.dao.CaptainRequestDAO;
import ru.rsreu.port.entity.*;
import ru.rsreu.port.entity.enums.CaptainRequestStatus;
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
        String query = resourcer.getString("request.save");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, request.getCaptainId());
            statement.setString(2, request.getDatetime());
            statement.setString(3, request.getStatus().toString());
            statement.setString(4, request.getType().toString());
            statement.setInt(5, request.getPierId());
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
        return requests;
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
        return requests;
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
    public Integer findNumberRequestByCaptain(Integer captainId) {
        String query = ProjectResourcer.getInstance().getString("request.find.by.captain");
        List<CaptainRequest> requests = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, captainId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                requests.add(DAOMapper.mapCaptainRequest(rs));
            }
            return requests.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public CaptainRequest findCurrentRequestByCaptain(Integer captainId){
        String query = ProjectResourcer.getInstance().getString("request.find.request_by_captain");
        CaptainRequest request = new CaptainRequest();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, captainId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                request = DAOMapper.mapCaptainRequest(rs);
            }
            return request;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changeStatusToCompleted(Integer id) {
        String query = resourcer.getString("request.change.status");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, CaptainRequestStatus.COMPLETED.toString());
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeStatusToApproved(Integer id) {
        String query = resourcer.getString("request.change.status");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, CaptainRequestStatus.APPROVED.toString());
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeStatusToCancelled(Integer id) {
        String query = resourcer.getString("request.change.status");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, CaptainRequestStatus.CANCELLED.toString());
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeStatusToRejected(Integer id) {
        String query = resourcer.getString("request.change.status");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, CaptainRequestStatus.REJECED.toString());
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPier(Integer idRequest, Integer idPier) {
        String query = resourcer.getString("request.set.pier");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPier);
            statement.setInt(2, idRequest);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query = resourcer.getString("set.pier");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, findById(idRequest).getCaptainId());
            statement.setInt(2, idPier);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void freePier(Integer idPier) {
        String query = resourcer.getString("free.pier");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPier);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
