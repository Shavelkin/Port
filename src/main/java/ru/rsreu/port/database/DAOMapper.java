package ru.rsreu.port.database;

import ru.rsreu.port.entity.CaptainRequest;
import ru.rsreu.port.entity.Ship;
import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.Session;
import ru.rsreu.port.entity.enums.CaptainRequestStatus;
import ru.rsreu.port.entity.enums.Roles;
import ru.rsreu.port.entity.enums.Type;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMapper {
    public static Session mapSession(ResultSet rs) throws SQLException {
        return new Session(
                rs.getInt("session_id"),
                DAOMapper.mapUser(rs),
                rs.getDate("active_until")
        );
    }

    public static User mapUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("name"),
                Roles.UNKNOWN
        );
    }

    public static User mapAdministrator(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("name"),
                Roles.ADMIN
        );
    }

    public static User mapDispatcher(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("name"),
                Roles.DISPATCHER
        );
    }

    public static User mapCaptain(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("name"),
                Roles.CAPTAIN
        );
    }

    public static CaptainRequest mapCaptainRequest(ResultSet rs) throws SQLException {
        return new CaptainRequest(
                rs.getInt("id"),
                rs.getInt("captain_id"),
                rs.getInt("pier_id"),
                rs.getString("datetime"),
                CaptainRequestStatus.valueOf(rs.getString("status")),
                Type.ENTERING
                //Type.valueOf(rs.getString("type"))
        );
    }


}
