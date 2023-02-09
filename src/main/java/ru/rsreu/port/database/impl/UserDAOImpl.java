package ru.rsreu.port.database.impl;

import ru.rsreu.port.database.AbstractDAO;
import ru.rsreu.port.database.dao.UserDAO;
import ru.rsreu.port.entity.User;
import ru.rsreu.port.database.DAOMapper;
import ru.rsreu.port.entity.enums.Roles;
import ru.rsreu.port.resourcer.ProjectResourcer;
import ru.rsreu.port.utils.UserUtil;

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

    @Override
    public void save(User user) {
        String roleRequest =  UserUtil.getNameRequestByRole(user.getUserRole());
        String query = resourcer.getString(roleRequest);
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer userId, User newUser) {
        String roleRequest =  UserUtil.getDeleteRequestByRole(newUser.getUserRole());
        String query = resourcer.getString(roleRequest);
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newUser.getLogin());
            statement.setString(2, newUser.getPassword());
            statement.setString(3, newUser.getName());
            statement.setInt(3, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer userId, Roles userRole) {
        String roleRequest =  UserUtil.getDeleteRequestByRole(userRole);
        String query = resourcer.getString(roleRequest);
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, userId);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        String query = resourcer.getString("admin.find.all");
        try (PreparedStatement st = connection.prepareStatement(query)) {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                users.add(DAOMapper.mapAdministrator(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        query = resourcer.getString("dispatcher.find.all");
        try (PreparedStatement st = connection.prepareStatement(query)) {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                users.add(DAOMapper.mapDispatcher(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        query = resourcer.getString("captain.find.all");
        try (PreparedStatement st = connection.prepareStatement(query)) {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                users.add(DAOMapper.mapCaptain(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
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
