package ru.rsreu.port.service;

import ru.rsreu.port.entity.User;
import ru.rsreu.port.database.DAOFactory;
import ru.rsreu.port.database.dao.UserDAO;
import ru.rsreu.port.dto.UserInfoDTO;

public class UserService {
    private static UserService instance;
    private final UserDAO userDAO;
    public static UserService getInstance() {
        synchronized (UserService.class) {
            if (instance == null) {
                instance = new UserService(DAOFactory.getUserDAO(), ServiceFactory.getMarkService());
            }
        }
        return instance;
    }
    public User getUser(String login) {
        return userDAO.findUserByLogin(login);
    }
}
