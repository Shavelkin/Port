package ru.rsreu.port.database;

import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.enums.Roles;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMapper {
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
}
