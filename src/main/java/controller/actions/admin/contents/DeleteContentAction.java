package controller.actions.admin.contents;

import controller.actions.IAction;
import model.database.ContentMetaDAO;
import model.database.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteContentAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String doi = request.getParameter("doi");

        DAO contentDAO = new ContentMetaDAO();
        contentDAO.delete(doi);

        response.sendRedirect("/admin/content");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/content/delete-content.jsp");
        requestDispatcher.forward(request,response);

    }
}
