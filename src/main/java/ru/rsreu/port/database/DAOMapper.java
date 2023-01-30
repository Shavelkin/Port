package ru.rsreu.port.database;

import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.Session;
import ru.rsreu.port.entity.enums.Roles;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMapper {
    public static Session mapSession(ResultSet rs) throws SQLException {
        return new Session(
                rs.getInt("session_id"),
                DAOMapper.mapAdministrator(rs),
                rs.getDate("active_until")
        );
    }
    public User mapAdministrator(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("name"),
                Roles.ADMIN
        );
    }

    public User mapDispatcher(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("name"),
                Roles.DISPATCHER
        );
    }

    public User mapCaptain(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("name"),
                Roles.CAPTAIN
        );
    }
}
