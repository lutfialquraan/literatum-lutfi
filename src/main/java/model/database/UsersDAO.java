package model.database;

import model.enums.Role;
import model.users.AbstractBaseUser;
import model.users.Admin;
import model.users.BasicUser;
import model.users.SuperAdmin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends DAO {

    @Override
    public void insert(Object object) {

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
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object object) {
        try {
            String email = (String) object;
            String sql = "delete from user_table WHERE email = ?";
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object object) {

    }

    @Override
    public List<Object> selectAll() {
        List<Object> users = new ArrayList<>();
        Statement myStat;
        ResultSet myRes;
        try {
            String sql = "select * from user_table order by email";
            myStat = connectionPool.getConnection().createStatement();
            myRes = myStat.executeQuery(sql);
            users = getUser(myRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


    @Override
    public Object select(Object object) {
        AbstractBaseUser baseUser = null;
        PreparedStatement myStat;
        String email_id = (String) object;
        ResultSet myRes = null;
        try {
            String sql = "select * from user_table where email=?";
            myStat = connectionPool.getConnection().prepareStatement(sql);
            myStat.setString(1, email_id);
            myRes = myStat.executeQuery();
            baseUser = (AbstractBaseUser) getUser(myRes).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return baseUser;
    }


    private Role getRole(int value) {
        switch (value) {
            case 0:
                return Role.SUPERADMIN;
            case 1:
                return Role.ADMIN;
            case 2:
                return Role.USER;
        }

        return Role.USER;
    }

    private List<Object> getUser(ResultSet resultSet) {

        List<Object> users = new ArrayList<>();
        AbstractBaseUser baseUser = null;
        try {
            while (resultSet.next()) {

                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String user_name = resultSet.getString("user_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Role role = getRole(resultSet.getInt("role"));
                switch (role) {
                    case SUPERADMIN:
                        baseUser = new SuperAdmin(first_name, last_name, user_name, email, password);
                        break;
                    case ADMIN:
                        baseUser = new Admin(first_name, last_name, user_name, email, password);
                        break;
                    case USER:
                        baseUser = new BasicUser(first_name, last_name, user_name, email, password);
                        break;
                }
                users.add(baseUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


}
