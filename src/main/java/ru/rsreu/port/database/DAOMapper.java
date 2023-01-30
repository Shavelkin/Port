package ru.rsreu.port.database;

import ru.rsreu.port.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMapper {
    public static User mapUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("user_id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("name"),
                Roles.valueOf(rs.getString("user_role"))
        );
    }
}
