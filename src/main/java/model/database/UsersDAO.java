package model.database;

import model.users.AbstractBaseUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends DAO {

    @Override
    void insert(Object object) {

        AbstractBaseUser baseUser = (AbstractBaseUser) object;
        try {
            String sql = "insert into user_table (first_name,last_name,user_name,email,password,role) values (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, baseUser.getFirstName());
            preparedStatement.setString(2, baseUser.getLastName());
            preparedStatement.setString(3, baseUser.getUserName());
            preparedStatement.setString(4, baseUser.getEmail());
            preparedStatement.setString(5, baseUser.getPassword());
            preparedStatement.setInt(6, baseUser.getRole().getValue());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); }
    }

    @Override
    void delete(Object object) {
        try {
            String email = (String) object;
            String sql = "delete from user_table WHERE name = ?";
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    void update(Object object) {

    }

    @Override
    List<Object> selectAll() {
        List<AbstractBaseUser> users = new ArrayList<>();
        Statement myStat = null;
        ResultSet myRes = null;
        try {
            String sql = "select * from user_table order by email";
            myStat = connectionPool.getConnection().createStatement();
            myRes = myStat.executeQuery(sql);

            while (myRes.next()) {


                Student student = new Student(firstName, lastName, email, id);
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }



    @Override
    Object select() {
        return null;
    }
}
