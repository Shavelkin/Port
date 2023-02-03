package ru.rsreu.port.database.impl;

import ru.rsreu.port.database.AbstractDAO;
import ru.rsreu.port.database.dao.UserDAO;
import ru.rsreu.port.entity.User;
import ru.rsreu.port.database.DAOMapper;
import ru.rsreu.port.entity.enums.Roles;
import ru.rsreu.port.resourcer.ProjectResourcer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImpl extends AbstractDAO implements UserDAO {
    private static UserDAOImpl instance;
    @Override
    public User findUserByLogin(String login) {
        Roles role = defineRoleUserByLogin(login);
        switch (role.getRussianName()) {
            case "Администратор": return findAdminByLogin(login);
            case "Диспетчер": return findDispatcherByLogin(login);
            case "Капитан": return findCaptainByLogin(login);
        }
        return new User();


    }

    private Roles defineRoleUserByLogin(String login) {
        if(findAdminByLogin(login).getUserRole().equals(Roles.ADMIN)){
            return Roles.ADMIN;
        } else if (findDispatcherByLogin(login).getUserRole().equals(Roles.DISPATCHER)){
            return Roles.DISPATCHER;
        } else if (findCaptainByLogin(login).getUserRole().equals(Roles.CAPTAIN)){
            return Roles.CAPTAIN;
        } else {
            return Roles.UNKNOWN;
        }



    }


    private User findAdminByLogin(String login) {
        String query = ProjectResourcer.getInstance().getString("user.find_admin.login");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return DAOMapper.mapAdministrator(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

    private User findDispatcherByLogin(String login) {
        String query = ProjectResourcer.getInstance().getString("user.find_dispatcher.login");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return DAOMapper.mapDispatcher(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

    private User findCaptainByLogin(String login) {
        String query = ProjectResourcer.getInstance().getString("user.find_captain.login");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return DAOMapper.mapCaptain(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

    public static UserDAOImpl getInstance() {
        synchronized (UserDAOImpl.class) {
            if (instance == null) {
                instance = new UserDAOImpl();
            }
        }
        return instance;
    }
}
