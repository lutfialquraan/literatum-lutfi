package controller.actions.admin.backstage;

import controller.actions.IAction;
import model.database.SubmittedFileDAO;
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/FileIsSubmited.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processFiles();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);

    }

    private void processFiles ()
    {
        SubmittedFileDAO dao = new SubmittedFileDAO();
        List<String> unprocessedFiles = dao.getUnprocessedFile();
        ThreadPool pool = ThreadPool.getInstance();
        for (String unprocessedFile: unprocessedFiles)
        {
            pool.execute(new ProcessingFiles(unprocessedFile));
        }
    }
}
