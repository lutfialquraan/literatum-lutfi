package test;

import java.util.List;

public abstract class DAO {
    ConnectionPool connectionPool;

    public DAO() {
        connectionPool = ConnectionPool.getInstance();
    }

    abstract public void insert (Object object);
    abstract public void delete (Object object);
    abstract public void update (Object object);
    abstract public List<Object> selectAll();
    abstract public Object select(Object object);
}
