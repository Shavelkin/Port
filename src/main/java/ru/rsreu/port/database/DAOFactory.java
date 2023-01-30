package ru.rsreu.port.database;
import ru.rsreu.port.database.dao.SessionDAO;
import ru.rsreu.port.database.dao.UserDAO;
import ru.rsreu.port.database.impl.UserDAOImpl;
import ru.rsreu.port.database.impl.SessionDAOImpl;
public class DAOFactory {
    public static SessionDAO getSessionDAO() {return SessionDAOImpl.getInstance();}
    public static UserDAO getUserDAO() {return UserDAOImpl.getInstance();}
}
