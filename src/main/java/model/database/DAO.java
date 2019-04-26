package model.database;

import java.sql.SQLException;
import java.util.List;

public abstract class DAO {
    ConnectionPool connectionPool;

    public DAO() {
        connectionPool = ConnectionPool.getInstance();
    }

    abstract void insert (Object object);
    abstract void delete (Object object) throws SQLException, ClassNotFoundException;
    abstract void update (Object object);
    abstract List<Object> selectAll();
    abstract Object select();
}
