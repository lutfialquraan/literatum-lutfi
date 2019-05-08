package controller.actions.admin.backstage;

import controller.actions.IAction;
import model.database.SubmittedFileDAO;
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
        if (AccessControl.isLoggedIn(request))
        {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/backstage/process-file.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            response.sendRedirect("/admin");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (AccessControl.isLoggedIn(request))
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
