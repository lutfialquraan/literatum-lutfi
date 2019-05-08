package controller.actions.admin.backstage;

import controller.actions.IAction;
import model.contents.SubmittedFile;
import model.database.DAO;
import model.database.SubmittedFileDAO;
import model.enums.Role;
import model.enums.Status;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utilities.AccessControl;
import utilities.DirectoryPaths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UploadFileAction implements IAction {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && (AccessControl.isAdmin(role) || AccessControl.isSuperAdmin(role))) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/backstage/upload-files.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/admin");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && (AccessControl.isAdmin(role) || AccessControl.isSuperAdmin(role))) {
            writeFileWithException(request);
            response.sendRedirect("/admin/backstage/processFile");
        } else {
            response.sendRedirect("/admin");
        }
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

        String fileName = DirectoryPaths.SUBMITTED_FILE_PATH + items.get(0).getName();
        SubmittedFile submittedFile = new SubmittedFile(fileName, Status.UNPROCESSED);
        DAO unprocessedFileDAO = new SubmittedFileDAO();
        unprocessedFileDAO.insert(submittedFile);
        File file = new File(fileName);
        if (!file.exists())
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