package ru.rsreu.port.database.dao;

import ru.rsreu.port.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> findAll();
    User findUserById(Integer id);
    User findUserByLogin(String login);
    Optional<User> update(User user);
    void delete(User user);
    void save(User user);
}