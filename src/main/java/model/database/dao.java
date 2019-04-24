package model.database;

import model.AbstractBaseUser;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dao {



    ConncetionPool conncetionPool;

    public dao() {
        conncetionPool = ConncetionPool.getInstance();
    }



        public void insertQuery (AbstractBaseUser user) throws SQLException {

        String string = "insert into user_table (first_name,last_name,user_name,email,password,role) values (?,?,?,?,?,?);";
        PreparedStatement preparedStatement = conncetionPool.getConnection().prepareStatement(string);
        preparedStatement.setString(1,user.getFirstName());
        preparedStatement.setString(2,user.getLastName());
        preparedStatement.setString(3,user.getUserName());
        preparedStatement.setString(4,user.getEmail());
        preparedStatement.setString(5,user.getPassword());
        preparedStatement.setInt(6, user.getRole().getValue());
        preparedStatement.execute();
    }


}
