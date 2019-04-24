package controller.wat;

import controller.actions.IAction;
import model.AbstractBaseUser;
import model.database.dao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class Admin implements IAction {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {


        String method = request.getMethod();

        switch (method) {
            case "POST":
                doPost(request,response);
                break;
            case "GET":
                doGet(request,response);
                break;
        }



    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        AbstractBaseUser admin = new model.Admin("lut","om","ooook","2551","2");
        dao dao1 = new dao();
        dao1.insertQuery(admin);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/wat.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }



    private void writeFileWithException(HttpServletRequest req) throws Exception {


          String fileName = "/home/lquran/Desktop/Litratum/literatum-lutfi/content" +"/a.zip";

//        Dao dao = new UnprocessedDao(ConnectionPool.getConnectionPool().getConnection());
//        int idx = fileName.lastIndexOf('/');
//        dao.addEntry(fileName.substring(idx + 1));

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Set factory constraints
//        factory.setSizeThreshold(100000);
//        File file = new File(fileName);
//        File repo = new File(fileName.substring(0, fileName.length() - 4));
//        factory.setRepository(repo);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(10000000000L);

        // Parse the request
        List<FileItem> items = upload.parseRequest(req);
        // Process the uploaded items
        Iterator<FileItem> iter = items.iterator();

        //uploadedFile.createNewFile();
//        iter.next().write(file);
//
//        if (repo.exists()) {
//            repo.delete();
//        }
    }


}