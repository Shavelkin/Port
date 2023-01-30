package ru.rsreu.port.database.impl;

import ru.rsreu.port.database.AbstractDAO;
import ru.rsreu.port.database.dao.SessionDAO;
import ru.rsreu.port.entity.Session;
import ru.rsreu.port.entity.User;
import ru.rsreu.port.database.DAOMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SessionDAOImpl extends AbstractDAO implements SessionDAO {

    private static SessionDAOImpl instance;

    public static SessionDAOImpl getInstance() {
        synchronized (SessionDAOImpl.class) {
            if (instance == null) {
                instance = new SessionDAOImpl();
            }
        }
        return instance;
    }

    @Override
    public void update(Session session) {
        String query = resourcer.getString("session.update");

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, new Date(session.getActiveUntil().getTime()));
            statement.setLong(2, session.getSession_id());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Session> findAllByUserStatus(String status) {
        String query = resourcer.getString("session.find.all.status");
        List<Session> sessions = new ArrayList<>();

        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString(1, status);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                sessions.add(DAOMapper.mapSession(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sessions;
    }

    @Override
    public void save(Session session) {
        String query = resourcer.getString("session.save");

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, session.getUser().getUserId());
            statement.setTimestamp(2, new Timestamp(session.getActiveUntil().getTime()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Session> findAll() {
        String query = resourcer.getString("session.find.all");
        List<Session> sessions = new ArrayList<>();

        try (PreparedStatement st = connection.prepareStatement(query)) {
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                sessions.add(DAOMapper.mapSession(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sessions;
    }

    @Override
    public void delete(User user) {
        String query = resourcer.getString("session.delete");

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, user.getUserId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Session> findByUserId(Integer userId) {
        String query = resourcer.getString("session.find.by.id");

        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setLong(1, userId);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                return Optional.of(DAOMapper.mapSession(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }


}
