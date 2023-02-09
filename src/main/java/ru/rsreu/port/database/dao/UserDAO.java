package ru.rsreu.port.database.dao;

import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.enums.Roles;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    User findUserByLogin(String login);
    void save(User user);
    void delete(Integer userId, Roles userRole);
    void update(Integer userId, User newUser);
    List<User> getAllUsers();
//    User findUserById(Integer id);
//    Optional<User> update(User user);
//    void delete(User user);

}
