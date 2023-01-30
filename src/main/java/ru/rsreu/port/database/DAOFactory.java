package ru.rsreu.port.database;
import ru.rsreu.port.database.dao.SessionDAO;
public class DAOFactory {
    public static SessionDAO getSessionDAO() {return SessionDAOImpl.getInstance();}
}
