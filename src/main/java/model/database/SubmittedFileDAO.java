package model.database;

import model.contents.SubmittedFile;
import model.enums.Status;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubmittedFileDAO extends DAO {

    @Override
    public void insert(Object object) {
        try {
            SubmittedFile file = (SubmittedFile) object;
            String sql = "insert into unprocessed_file (file_path, status) values (?,?)";
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, file.getFilePath());
            preparedStatement.setInt(2, file.getStatus().getValue());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object object) {
        try {
            String file_path = (String) object;
            String sql = "delete from unprocessed_file where file_path = ? ";
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, file_path);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object object) {
        try {
            String file_path = (String) object;
            String sql = "update unprocessed_file set status =? where file_path = ? ;";
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, Status.PROCESSED.getValue());
            preparedStatement.setString(2, file_path);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Object> selectAll() {
        List<Object> files = new ArrayList<>();
        Statement myStat;
        ResultSet myRes;
        try {
            String sql = "select * from unprocessed_file order by file_id";
            myStat = connectionPool.getConnection().createStatement();
            myRes = myStat.executeQuery(sql);
            files = getFile(myRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }

    @Override
    public Object select(Object object) {
        SubmittedFile file = null;
        PreparedStatement myStat;
        int file_id = (int) object;
        ResultSet myRes = null;
        try {
            String sql = "select * from user_table where file_id = ?";
            myStat = connectionPool.getConnection().prepareStatement(sql);
            myStat.setInt(1, file_id);
            myRes = myStat.executeQuery();
            file = (SubmittedFile) getFile(myRes).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }


    public List<String> getUnprocessedFile() {
        List<String> filePaths = new ArrayList<>();
        Statement myStat;
        ResultSet myRes;
        try {
            String sql = "select file_path from unprocessed_file where status = 0";
            myStat = connectionPool.getConnection().createStatement();
            myRes = myStat.executeQuery(sql);
            while (myRes.next()) {
                String filePath = myRes.getString("file_path");
                filePaths.add(filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePaths;


    }


    private List<Object> getFile(ResultSet resultSet) {
        List<Object> files = new ArrayList<>();
        SubmittedFile file = null;
        try {
            while (resultSet.next()) {

                String file_path = resultSet.getString("file_path");
                Status status = getStatus(resultSet.getInt("status"));
                int file_id = resultSet.getInt("file_id");
                file = new SubmittedFile(file_path, status, file_id);
                files.add(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }

    private Status getStatus(int value) {
        switch (value) {
            case 0:
                return Status.UNPROCESSED;
            case 1:
                return Status.PROCESSING;
            case 2:
                return Status.PROCESSED;
        }

        return Status.UNPROCESSED;
    }


}
