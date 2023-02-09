package ru.rsreu.port.service;

import ru.rsreu.port.entity.User;
import ru.rsreu.port.database.DAOFactory;
import ru.rsreu.port.database.dao.UserDAO;
import ru.rsreu.port.entity.enums.Roles;

import java.util.List;

public class UserService {
    private static UserService instance;
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public static UserService getInstance() {
        synchronized (UserService.class) {
            if (instance == null) {
                instance = new UserService(DAOFactory.getUserDAO());
            }
        }
        return instance;
    }
    public User getUser(String login) {
        return userDAO.findUserByLogin(login);
    }
    public void addUser(User user) {
        userDAO.save(user);
    }
    public void deleteUser(Integer userId, Roles userRole) {
        userDAO.delete(userId, userRole);
    }

    public List<User> getAllUsers() { return userDAO.getAllUsers(); };

}
