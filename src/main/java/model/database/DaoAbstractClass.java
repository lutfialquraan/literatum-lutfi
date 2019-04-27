package model.database;

import model.ContentTable;
import model.ContentMeta;
import model.UnprocessedFile;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoAbstractClass {

    ConnectionPool connectionPool;

    public DaoAbstractClass() {
        connectionPool = ConnectionPool.getInstance();
    }







//        public void insertQuery (AbstractBaseUser user) throws SQLException, ClassNotFoundException {
//
//
//        String string = "insert into user_table (first_name,last_name,user_name,email,password,role) values (?,?,?,?,?,?);";
//        PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(string);
//        preparedStatement.setString(1,user.getFirstName());
//        preparedStatement.setString(2,user.getLastName());
//        preparedStatement.setString(3,user.getUserName());
//        preparedStatement.setString(4,user.getEmail());
//        preparedStatement.setString(5,user.getPassword());
//        preparedStatement.setInt(6, user.getRole().getValue());
//        preparedStatement.execute();
//    }




        public void insertFile (UnprocessedFile file) throws SQLException, ClassNotFoundException {


        String string = "insert into unprocessed_file (file_path, status) values (?,?)";
        PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(string);
        preparedStatement.setString(1,file.getFilePath());
        preparedStatement.setInt(2,file.getStatus().getValue());
        preparedStatement.execute();
    }


    public void insertMeta (ContentMeta contentMeta) throws SQLException, ClassNotFoundException {


        String string = "insert into content_meta (doi, subject, article_title, author) values (?,?,?,?)";
        PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(string);
        preparedStatement.setString(1,contentMeta.getTheDoi());
        preparedStatement.setString(2,contentMeta.getSubject());
        preparedStatement.setString(3,contentMeta.getTitle());
        preparedStatement.setString(4,contentMeta.getAuthor());
        preparedStatement.execute();
    }


    public void insertContent (ContentTable contentTable) throws SQLException, ClassNotFoundException {


        String string = "insert into conetnt_table (doi, path_for_xml, path_for_html, path_for_pdf) values (?,?,?,?)  ";
        PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(string);
        preparedStatement.setString(1, contentTable.getTheDoi());
        preparedStatement.setString(2, contentTable.getPathForXml());
        preparedStatement.setString(3, contentTable.getPathForHtml());
        preparedStatement.setString(4, contentTable.getPathForPdf());
        preparedStatement.execute();
    }




}
