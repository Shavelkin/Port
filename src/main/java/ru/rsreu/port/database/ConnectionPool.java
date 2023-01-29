package ru.rsreu.port.database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static final String DATASOURCE_NAME = "java:/comp/env/jdbc/port";
    private static DataSource dataSource;
    private static Connection connection;

    static {
        try {
            Context initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup(DATASOURCE_NAME);
            connection = dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    private ConnectionPool() {
    }

    public static Connection getConnection() {
        return connection;
    }
}
