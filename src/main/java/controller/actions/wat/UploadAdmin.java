package controller.actions.wat;

import controller.actions.IAction;
import controller.actions.backstage.ProcessingAction;
import model.database.DAO;
import model.database.UnprocessedFileDAO;
import model.enums.Status;
import model.UnprocessedFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utilities.DirectoryPaths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class UploadAdmin implements IAction {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/wat.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        writeFileWithException(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/FileIsSubmited.jsp");
        requestDispatcher.forward(request, response);
    }

    private void writeFileWithException(HttpServletRequest req) throws Exception {


        System.out.println(ServletFileUpload.isMultipartContent(req));
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // Set factory constraints
        factory.setSizeThreshold(100000);
        File repo = new File(DirectoryPaths.SUBMITTED_FILE_PATH);
        factory.setRepository(repo);
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // Set overall request size constraint
        upload.setSizeMax(10000000000L);
        // Parse the request
        List<FileItem> items = upload.parseRequest(req);
        // Process the uploaded items

        String fileName = DirectoryPaths.SUBMITTED_FILE_PATH+ items.get(0).getName();
        UnprocessedFile unprocessedFile = new UnprocessedFile(fileName, Status.UNPROCESSED);
        DAO unprocessedFileDAO = new UnprocessedFileDAO();
        unprocessedFileDAO.insert(unprocessedFile);
        File file = new File(fileName);
        items.get(0).write(file);

        /**Iterator<FileItem> iter = items.iterator();
        //uploadedFile.createNewFile();
        iter.next().write(file);
         **/
        if (repo.exists()) {
            repo.delete();
        }
    }
}