package controller.actions.admin.contents;

import controller.actions.IAction;
import model.database.ContentMetaDAO;
import model.database.DAO;
import utilities.AccessControl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteContentAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (AccessControl.isLoggedIn(request)) {
            String doi = request.getParameter("doi");

            DAO contentDAO = new ContentMetaDAO();
            contentDAO.delete(doi);
            response.sendRedirect("/admin/content");
        } else {
            response.sendRedirect("/admin");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (AccessControl.isLoggedIn(request)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/content/delete-content.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/admin");
        }
    }
}
