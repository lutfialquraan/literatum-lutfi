package controller.actions.admin.backstage;

import controller.actions.IAction;
import model.database.SubmittedFileDAO;
import model.enums.Role;
import utilities.AccessControl;
import utilities.ProcessingFiles;
import utilities.ThreadPool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class ProcessingAction implements IAction {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && (AccessControl.isAdmin(role) || AccessControl.isSuperAdmin(role)))
        {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/backstage/process-file.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            response.sendRedirect("/admin");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && (AccessControl.isAdmin(role) || AccessControl.isSuperAdmin(role)))
        {
            processFiles();
            response.sendRedirect("/admin/backstage/showFiles");
        }
        else {
            response.sendRedirect("/admin");
        }

    }

    private void processFiles() {
        SubmittedFileDAO dao = new SubmittedFileDAO();
        List<String> unprocessedFiles = dao.getUnprocessedFile();
        ThreadPool pool = ThreadPool.getInstance();
        for (String unprocessedFile : unprocessedFiles) {
            pool.execute(new ProcessingFiles(unprocessedFile));
        }
    }
}
