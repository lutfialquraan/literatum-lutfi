package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContentTableDAO extends DAO {
    @Override
    public void insert(Object object) {

        ContentTable contentTable = (ContentTable) object;
        String sql = "insert into conetnt_table (doi, path_for_xml, path_for_html, path_for_pdf) values (?,?,?,?)  ";
        try {
            PreparedStatement preparedStatement = connectionPool.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, contentTable.getTheDoi());
            preparedStatement.setString(2, contentTable.getPathForXml());
            preparedStatement.setString(3, contentTable.getPathForHtml());
            preparedStatement.setString(4, contentTable.getPathForPdf());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object object) {
        String doi = (String) object;
        String sql = "delete from content_table where doi = ? ";
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
        List<Object> contents = new ArrayList<>();
        Statement myStat;
        ResultSet myRes;
        try {
            String sql = "select * from conetnt_table order by doi";
            myStat = connectionPool.getConnection().createStatement();
            myRes = myStat.executeQuery(sql);
            contents = getContent(myRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents;
    }

    @Override
    public Object select(Object object) {
        ContentTable contentTable = null;
        PreparedStatement myStat;
        String doi = (String) object;
        ResultSet myRes = null;
        try {
            String sql = "select * from conetnt_table where doi = ?";
            myStat = connectionPool.getConnection().prepareStatement(sql);
            myStat.setString(1, doi);
            myRes = myStat.executeQuery();
            contentTable = (ContentTable) getContent(myRes).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentTable;
    }

    private List<Object> getContent(ResultSet resultSet) {
        List<Object> contents = new ArrayList<>();
        ContentTable content;
        try {
            while (resultSet.next()) {

                String doi = resultSet.getString("doi");
                String path_for_xml = resultSet.getString("path_for_xml");
                String path_for_html = resultSet.getString("path_for_html");
                String path_for_pdf = resultSet.getString("path_for_pdf");
                content = new ContentTable(path_for_pdf, path_for_html, path_for_xml, doi);
                contents.add(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents;
    }
}
