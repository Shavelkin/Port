package ru.rsreu.port.database.impl;

import ru.rsreu.port.database.AbstractDAO;
import ru.rsreu.port.database.dao.UserDAO;
import ru.rsreu.port.entity.User;
import ru.rsreu.port.database.DAOMapper;
import ru.rsreu.port.resourcer.ProjectResourcer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImpl extends AbstractDAO implements UserDAO {
    @Override
    public List<User> findAll() {
        String query = resourcer.getString("user.find.all");
        List<User> users = new ArrayList<>();

        try (PreparedStatement st = connection.prepareStatement(query)) {
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                users.add(DAOMapper.mapUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User findUserByLogin(String login) {
        String query = ProjectResourcer.getInstance().getString("user.find.login");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return DAOMapper.mapUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
