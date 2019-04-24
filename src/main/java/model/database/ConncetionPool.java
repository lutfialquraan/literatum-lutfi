package model.database;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConncetionPool {


    @Resource(name="connectionPool")
    private DataSource dataSource;
    private static ConncetionPool pool;
    private ConncetionPool () {}

    public static ConncetionPool getInstance(){
        if (pool==null)
            pool= new ConncetionPool();
        return pool;
    }

    public Connection getConnection () throws SQLException {

        return  dataSource.getConnection();
    }
}
