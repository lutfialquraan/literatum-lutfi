package model.database;

import model.license.License;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LicenseDAO extends DAO {
    @Override
    public void insert(Object object) {
        try {
            License license = (License) object;
             String sql = "insert into license_table (email,license) values (?,?)";
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, license.getEmail());
            preparedStatement.setObject(2, license.getDate());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object object) {
        try {
            String email = (String) object;
            String sql = "delete from license_table where email = ? ";
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object object) {
        try {
            License license = (License) object;
            String sql = "update license_table set license =? where id = ? ;";
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setObject(1,license.getDate());
            preparedStatement.setInt(2, license.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Object> selectAll() {
        List<Object> licenses = new ArrayList<>();
        Statement myStat;
        ResultSet myRes;
        try {
            String sql = "select * from license_table order by id";
            myStat = connectionPool.getConnection().createStatement();
            myRes = myStat.executeQuery(sql);
            licenses = getLicense(myRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return licenses;
    }

    @Override
    public Object select(Object object) {
        License license = null;
        PreparedStatement myStat;
        String email = (String) object;
        ResultSet myRes = null;
        try {
            String sql = "select * from license_table where email = ?";
            myStat = connectionPool.getConnection().prepareStatement(sql);
            myStat.setString(1, email);
            myRes = myStat.executeQuery();
            license = (License) getLicense(myRes).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return license;
    }

    private List<Object> getLicense(ResultSet resultSet) {
        List<Object> licenses = new ArrayList<>();
        License theLicense = null;
        try {
            while (resultSet.next()) {

                String email = resultSet.getString("email");
                LocalDate license = resultSet.getObject("license",LocalDate.class);
                int id = resultSet.getInt("id");
                theLicense = new License(id,email,license);
                licenses.add(theLicense);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return licenses;
    }
}
