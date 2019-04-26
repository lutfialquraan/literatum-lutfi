package model.database;

import model.users.AbstractBaseUser;

import java.sql.*;

public class UserDao {

    ConnectionPool connectionPool;

    public UserDao() {
        connectionPool = ConnectionPool.getInstance();
    }

//    public void insertUser(AbstractBaseUser user){
//
//
//
//        try {
//            String string = "insert into user_table (first_name,last_name,user_name,email,password,role) values (?,?,?,?,?,?);";
//            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(string);
//            preparedStatement.setString(1, user.getFirstName());
//            preparedStatement.setString(2, user.getLastName());
//            preparedStatement.setString(3, user.getUserName());
//            preparedStatement.setString(4, user.getEmail());
//            preparedStatement.setString(5, user.getPassword());
//            preparedStatement.setInt(6, user.getRole().getValue());
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            close(myConn, myStat, null);
//        }
//
//
//    }




    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null)
                connection.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
