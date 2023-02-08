package ru.rsreu.port.database.dao;

import ru.rsreu.port.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserDAO {
    User findUserByLogin(String login);
    void save(User user);
    List<User> getAllUsers();
//    User findUserById(Integer id);
//    Optional<User> update(User user);
//    void delete(User user);

}
