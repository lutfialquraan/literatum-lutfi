package controller.actions.admin.backstage;

import controller.actions.IAction;
import model.contents.SubmittedFile;
import model.database.DAO;
import model.database.SubmittedFileDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowSubmittedFilesAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doGet(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

        DAO submittedFileDAO = new SubmittedFileDAO();
        List <SubmittedFile> submittedFiles = (List<SubmittedFile>)(List<?>) submittedFileDAO.selectAll();
        request.setAttribute("files",submittedFiles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/backstage/show-submitted-files.jsp");
        dispatcher.forward(request,response);
    }
}
