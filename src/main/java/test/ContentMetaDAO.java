package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContentMetaDAO extends DAO {
    @Override
    public void insert(Object object) {
        ContentMeta contentMeta = (ContentMeta) object;
        String sql = "insert into content_meta (doi, subject, article_title, author) values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, contentMeta.getTheDoi());
            preparedStatement.setString(2, contentMeta.getSubject());
            preparedStatement.setString(3, contentMeta.getTitle());
            preparedStatement.setString(4, contentMeta.getAuthor());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object object) {
        String doi = (String) object;
        String sql = "delete from content_meta where doi = ? ";
        try {
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, doi);
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
        List<Object> contentMetas = new ArrayList<>();
        Statement myStat;
        ResultSet myRes;
        try {
            String sql = "select * from content_meta order by doi";
            myStat = connectionPool.getConnection().createStatement();
            myRes = myStat.executeQuery(sql);
            contentMetas = getMeta(myRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentMetas;

    }

    @Override
    public Object select(Object object) {
        ContentMeta contentMeta = null;
        PreparedStatement myStat;
        String doi = (String) object;
        ResultSet myRes = null;
        try {
            String sql = "select * from content_meta where doi = ?";
            myStat = connectionPool.getConnection().prepareStatement(sql);
            myStat.setString(1, doi);
            myRes = myStat.executeQuery();
            contentMeta = (ContentMeta) getMeta(myRes).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentMeta;

    }

    private List<Object> getMeta(ResultSet resultSet) {
        List<Object> contentsMeta = new ArrayList<>();
        ContentMeta contentMeta;
        try {
            while (resultSet.next()) {

                String doi = resultSet.getString("doi");
                String subject = resultSet.getString("subject");
                String article_title = resultSet.getString("article_title");
                String author = resultSet.getString("author");
                contentMeta = new ContentMeta(doi, subject, article_title, author);
                contentsMeta.add(contentMeta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentsMeta;
    }
}
