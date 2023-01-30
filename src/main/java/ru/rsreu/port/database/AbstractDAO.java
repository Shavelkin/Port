package ru.rsreu.port.database;

import java.sql.Connection;
import ru.rsreu.port.resourcer.ProjectResourcer;
import ru.rsreu.port.resourcer.Resourcer;

public abstract class AbstractDAO {
    protected Resourcer resourcer;
    protected Connection connection;

    public AbstractDAO() {
        this.resourcer = ProjectResourcer.getInstance();
        this.connection = ConnectionPool.getConnection();
    }
}
