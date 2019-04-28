package model.database;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

    private static ConnectionPool pool;

    private ConnectionPool() {
    }

    public synchronized static ConnectionPool getInstance() {
        if (pool == null)
            pool = new ConnectionPool();
        return pool;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "12345678");
        return connection;
    }
}
